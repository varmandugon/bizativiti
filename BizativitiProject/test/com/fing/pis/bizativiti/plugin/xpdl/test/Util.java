package com.fing.pis.bizativiti.plugin.xpdl.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class Util {

    private Util() {}

    public static Object parse(String input, Class cls) {
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return parse(stream, cls);
    }

    public static Object parse(InputStream stream, Class cls) {
        Object result = null;
        try {
            // Contexto JAXB con la clase que corresponde al root del xml
            JAXBContext xpdlContext = JAXBContext.newInstance(org.wfmc._2009.xpdl2.PackageType.class);
            Unmarshaller unmarshallerXpdl = xpdlContext.createUnmarshaller();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
            JAXBElement<Object> jaxbPackage = unmarshallerXpdl.unmarshal(reader, cls);
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