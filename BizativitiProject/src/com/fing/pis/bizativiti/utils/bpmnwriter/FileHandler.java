package com.fing.pis.bizativiti.utils.bpmnwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.w3c.dom.Document;

/**
 * Clase que encapsula la escritura de un archivo en BPMN
 * 
 * @author pis2013
 * 
 */
public class FileHandler {

    /**
     * Escribe un archivo en formato BPMN
     * 
     * @param bpmnStructure
     *            Nodo con la informacion a escribir
     * @param filePath
     *            Path la ruta y nombre del archivo a escribir.
     */
    public static void writeFile(JAXBElement<TDefinitions> bpmnStructure, String filePath) {

        JAXBContext jc;
        XMLOutputFactory factory = XMLOutputFactory.newInstance(); // Factory para obtener xmlreaders
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(filePath));
            jc = JAXBContext.newInstance(org.omg.spec.bpmn._20100524.model.TDefinitions.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bpmnStructure, writer);
            writer.close();

        } catch (JAXBException | XMLStreamException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Escribe en la salida estandar el resultado de serializar la estructura
     * BPMN
     * 
     * @param bpmnStructure
     *            Nodo con la informacion a escribir
     */
    public static void writeBPMN(JAXBElement<TDefinitions> bpmn) {
        Writer stream = new StringWriter();
        try {
            JAXBContext jc = JAXBContext.newInstance(org.omg.spec.bpmn._20100524.model.TDefinitions.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            final Transformer serializer = TransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            marshaller.marshal(bpmn, doc);
            serializer.transform(new DOMSource(doc), new StreamResult(stream));

        } catch (JAXBException | TransformerFactoryConfigurationError | ParserConfigurationException
                | TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(stream.toString());
    }
}