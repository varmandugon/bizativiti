package com.fing.pis.bizativiti.plugin.xpdl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import com.fing.pis.bizativiti.core.common.IPlugin;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelElement;

public class Facade implements IPlugin {

    // TODO: por ahora se genera un converter sin la intervención del usuario.
    // Hay que cambiar esto para que luego el usuario pueda mediante parametros cambiar la creación
    // @formatter:off
    private Converter converter = new Converter.Builder()
        .add(org.wfmc._2009.xpdl2.PackageType.class, new TranslatorPackageType())
        .add(org.wfmc._2009.xpdl2.ProcessType.class, new TranslatorProcessType())
        .add(org.wfmc._2009.xpdl2.WorkflowProcesses.class, new TranslatorWorkflowProcesses())
        .add(org.wfmc._2009.xpdl2.ProcessHeader.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.RedefinableHeader.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.ActivitySets.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.DataInputOutputs.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.ExtendedAttributes.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Activities.class, new TranslatorActivities())
        .add(org.wfmc._2009.xpdl2.Activity.class, new TranslatorActivity())
        .add(org.wfmc._2009.xpdl2.Description.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Event.class, new TranslatorEvent())
        .add(org.wfmc._2009.xpdl2.Documentation.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.NodeGraphicsInfos.class, DummyTranslator.getInstance())
        .create();
    // @formatter:on

    @Override
    public String getType() {
        return "xpdl";
    }

    @Override
    public List<MetamodelElement> parse(InputStream stream) {
        org.wfmc._2009.xpdl2.PackageType root = deserializeXML(stream);
        return converter.eval(root, new ArrayList<>());
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