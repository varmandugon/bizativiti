package com.fing.pis.bizativiti.plugin.xpdl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import com.fing.pis.bizativiti.IPlugin;
import com.fing.pis.bizativiti.metamodel.MetamodelElement;

public class Facade implements IPlugin {

    // TODO: por ahora se genera un converter sin la intervención del usuario.
    // Hay que cambiar esto para que luego el usuario pueda mediante parametros cambiar la creación
    private Converter converter = new Converter.Builder()
    // .add(, translator)
            .create();

    @Override
    public String getType() {
        return "xpdl";
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MetamodelElement> parse(InputStream stream) {
        org.wfmc._2009.xpdl2.PackageType root = deserializeXML(stream);
        Object result = converter.eval(root, new ArrayList<>());
        return (List<MetamodelElement>) result;
    }

    // TODO: verificar si pueden ocurrir casos en que el reader quede abierto y no se liberen recursos
    private org.wfmc._2009.xpdl2.PackageType deserializeXML(InputStream stream) {
        org.wfmc._2009.xpdl2.PackageType result = null;
        try {
            // Contexto JAXB con la clase que corresponde al root del xml
            JAXBContext xpdlContext = JAXBContext.newInstance(org.wfmc._2009.xpdl2.PackageType.class);
            Unmarshaller unmarshallerXpdl = xpdlContext.createUnmarshaller();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
            JAXBElement<org.wfmc._2009.xpdl2.PackageType> jaxbPackage = unmarshallerXpdl.unmarshal(reader,
                    org.wfmc._2009.xpdl2.PackageType.class);
            // Obrenemos el elemento root del xml 
            result = jaxbPackage.getValue();
            reader.close();
        } catch (Exception e) {
            // relanzar
            throw new RuntimeException(e);
        }
        return result;
    }

}