package com.fing.pis.bizativiti.bpmnwriter;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.di.BPMNDiagram;
import org.omg.spec.bpmn._20100524.di.BPMNPlane;
import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TProcess;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.metamodel.MetamodelPackage;

public class BPMNConverter {

    public JAXBElement<TDefinitions> convert(MetamodelPackage metamodel) {
        FactoryTranslator factory = new FactoryTranslator();
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
            Translator translator = factory.getTranslator(element);
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

}