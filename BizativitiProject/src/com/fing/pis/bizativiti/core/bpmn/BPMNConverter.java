package com.fing.pis.bizativiti.core.bpmn;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.spec.bpmn._20100524.di.BPMNDiagram;
import org.omg.spec.bpmn._20100524.di.BPMNPlane;
import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TProcess;
import org.omg.spec.dd._20100524.di.DiagramElement;
import org.w3c.dom.Document;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelPackage;

public class BPMNConverter {

    public static JAXBElement<TDefinitions> convert(MetamodelPackage metamodel) {
        Converter converter = FactoryConverter.getInstance();
        TranslatorState state = new TranslatorState();

        TDefinitions bpmnDefinitions = state.getModelFactory().createTDefinitions();
        TProcess bpmnProcess = state.getModelFactory().createTProcess();
        // En el plane se agregan los shapes y edges.
        BPMNPlane bpmnPlane = state.getDiagramFactory().createBPMNPlane();
        BPMNDiagram bpmnDiagram = state.getDiagramFactory().createBPMNDiagram();

        // Agrego el plano al diagrana
        bpmnDiagram.setBPMNPlane(bpmnPlane);
        bpmnDiagram.setId("BPMNDiagram_" + metamodel.getName());
        bpmnProcess.setId(metamodel.getName().replace(" ", "_"));

        // Referencia del proceso en el plano
        bpmnPlane.setId("BPMNPlane_" + metamodel.getName());
        bpmnPlane.setBpmnElement(new QName(bpmnProcess.getId()));

        // TProces guarda una lista de JAXBElements del tipo TFLowElement el cual es una clase padre
        // de activiti, sequenceflow, etc..

        for (MetamodelElement element : metamodel.getElements()) {
            ATranslator translator = converter.eval(element);
            JAXBElement<? extends TFlowElement> flowElement = translator.getFlowElement(element, state);
            JAXBElement<? extends DiagramElement> diagramElement = translator.getDiagramElement(element, state);

            // Si se generaron bien los dos elementos entonces los agrego a la lista.
            if (flowElement != null && diagramElement != null) {
                state.getElements().put(flowElement.getValue().getId(), flowElement.getValue()); // Guardo en el hashmap para poder referenciar elementos en los sequenceFlows
                bpmnProcess.getFlowElement().add(flowElement);
                bpmnPlane.getDiagramElement().add(diagramElement);
            }
        }
        JAXBElement<TProcess> JAXBProcess = state.getModelFactory().createProcess(bpmnProcess);
        bpmnDefinitions.getBPMNDiagram().add(bpmnDiagram);
        bpmnDefinitions.getRootElement().add(JAXBProcess);
        JAXBElement<TDefinitions> jaxbBpmnDefinitions = state.getModelFactory().createDefinitions(bpmnDefinitions);
        return jaxbBpmnDefinitions;
    }

    public static void writeBPMN(JAXBElement<TDefinitions> bpmn, OutputStream out) {
        Writer stream = new OutputStreamWriter(out);
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}