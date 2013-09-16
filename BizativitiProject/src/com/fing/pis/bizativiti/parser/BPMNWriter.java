package com.fing.pis.bizativiti.parser;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.di.BPMNDiagram;
import org.omg.spec.bpmn._20100524.di.BPMNEdge;
import org.omg.spec.bpmn._20100524.di.BPMNPlane;
import org.omg.spec.bpmn._20100524.di.BPMNShape;
import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.omg.spec.bpmn._20100524.model.TEndEvent;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TGateway;
import org.omg.spec.bpmn._20100524.model.TInclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TManualTask;
import org.omg.spec.bpmn._20100524.model.TParallelGateway;
import org.omg.spec.bpmn._20100524.model.TProcess;
import org.omg.spec.bpmn._20100524.model.TSequenceFlow;
import org.omg.spec.bpmn._20100524.model.TStartEvent;
import org.omg.spec.bpmn._20100524.model.TTask;
import org.omg.spec.bpmn._20100524.model.TUserTask;
import org.omg.spec.dd._20100524.dc.Bounds;
import org.omg.spec.dd._20100524.dc.Point;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.metamodel.MetamodelConnector;
import com.fing.pis.bizativiti.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.metamodel.MetamodelGateway;
import com.fing.pis.bizativiti.metamodel.MetamodelInclusiveGateway;
import com.fing.pis.bizativiti.metamodel.MetamodelManualTask;
import com.fing.pis.bizativiti.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.metamodel.MetamodelParallelGateway;
import com.fing.pis.bizativiti.metamodel.MetamodelSequenceFlow;
import com.fing.pis.bizativiti.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.metamodel.MetamodelTask;
import com.fing.pis.bizativiti.metamodel.MetamodelUserTask;

public class BPMNWriter {

    private org.omg.spec.bpmn._20100524.model.ObjectFactory modelFactory;
    private org.omg.spec.bpmn._20100524.di.ObjectFactory diagramFactory;
    private org.omg.spec.dd._20100524.di.ObjectFactory diDiagramFactory;
    private org.omg.spec.dd._20100524.dc.ObjectFactory dcDiagramFactory;
    Map<String, TFlowElement> bpmnElements;

    public BPMNWriter() {
        modelFactory = new org.omg.spec.bpmn._20100524.model.ObjectFactory();
        diagramFactory = new org.omg.spec.bpmn._20100524.di.ObjectFactory();
        diDiagramFactory = new org.omg.spec.dd._20100524.di.ObjectFactory();
        dcDiagramFactory = new org.omg.spec.dd._20100524.dc.ObjectFactory();
        bpmnElements = new HashMap<String, TFlowElement>();
    }

    public JAXBElement<TDefinitions> convert(MetamodelPackage metamodel) {
        bpmnElements.clear(); // solo por si acaso lo vacio.

        TDefinitions bpmnDefinitions = modelFactory.createTDefinitions();
        TProcess bpmnProcess = modelFactory.createTProcess();
        // En el plane se agregan los shapes y edges.
        BPMNPlane bpmnPlane = diagramFactory.createBPMNPlane();
        BPMNDiagram bpmnDiagram = diagramFactory.createBPMNDiagram();

        // Agrego el plano al diagrana
        bpmnDiagram.setBPMNPlane(bpmnPlane);
        bpmnDiagram.setId("BPMNDiagram_" + metamodel.getName());
        bpmnProcess.setId(metamodel.getName());

        // Referencia del proceso en el plano
        bpmnPlane.setId("BPMNPlane_" + metamodel.getName());
        bpmnPlane.setBpmnElement(new QName(bpmnProcess.getId()));

        // TProces guarda una lista de JAXBElements del tipo TFLowElement el cual es una clase padre
        // de activiti, sequenceflow, etc..

        JAXBElement<? extends TFlowElement> flowElement;
        JAXBElement<? extends DiagramElement> diagramElement;
        for (MetamodelElement element : metamodel.getElements()) {
            // Siempre arrancarlos en nulo
            flowElement = null;
            diagramElement = null;

            if (isStartEvent(element)) {
                MetamodelStartEvent startEvent = (MetamodelStartEvent) element;
                flowElement = createStartEvent(startEvent);
                diagramElement = createShape(element);
            } else if (isEndEvent(element)) {
                flowElement = createEndEvent((MetamodelEndEvent) element);
                diagramElement = createShape(element);
            } else if (isSequenceFlow(element)) {
                flowElement = createSequenceFlow((MetamodelSequenceFlow) element);
                diagramElement = createEdge(element);
            } else if (isTask(element)) {
                flowElement = createTask((MetamodelTask) element);
                diagramElement = createShape(element);
            } else if (isGateWay(element)) {
                flowElement = createGateWay((MetamodelGateway) element);
                diagramElement = createShape(element);
            }

            // Si se generaron bien los dos elementos entonces los agrego a la lista.
            if (flowElement != null && diagramElement != null) {
                bpmnElements.put(flowElement.getValue().getId(), flowElement.getValue()); // Guardo en el hashmap para poder referenciar elementos en los sequenceFlows
                bpmnProcess.getFlowElement().add(flowElement);
                bpmnPlane.getDiagramElement().add(diagramElement);
            }
        }

        JAXBElement<TProcess> JAXBProcess = modelFactory.createProcess(bpmnProcess);

        bpmnDefinitions.getBPMNDiagram().add(bpmnDiagram);
        bpmnDefinitions.getRootElement().add(JAXBProcess);

        JAXBElement<TDefinitions> jaxbBpmnDefinitions = modelFactory.createDefinitions(bpmnDefinitions);
        return jaxbBpmnDefinitions;
    }

    private boolean isGateWay(MetamodelElement element) {
        return element instanceof MetamodelGateway;
    }

    private boolean isTask(MetamodelElement element) {
        return element instanceof MetamodelTask;
    }

    private boolean isUserTask(MetamodelElement element) {
        return element instanceof MetamodelUserTask;
    }

    private boolean isManualTask(MetamodelElement element) {
        return element instanceof MetamodelManualTask;
    }

    private boolean isStartEvent(MetamodelElement element) {
        return element instanceof MetamodelStartEvent;
    }

    private boolean isEndEvent(MetamodelElement element) {
        return element instanceof MetamodelEndEvent;
    }

    private boolean isSequenceFlow(MetamodelElement element) {
        return element instanceof MetamodelSequenceFlow;
    }

    private boolean isInclusiveGateway(MetamodelGateway element) {
        return element instanceof MetamodelInclusiveGateway;
    }

    private boolean isParallelGateway(MetamodelGateway element) {
        return element instanceof MetamodelParallelGateway;
    }

    private JAXBElement<BPMNEdge> createEdge(MetamodelElement element) {
        MetamodelConnector connector = (MetamodelConnector) element;
        BPMNEdge edge = diagramFactory.createBPMNEdge();
        edge.setId("BPMNEdge_sid-" + connector.getId());
        edge.setBpmnElement(new QName(connector.getId())); //TODO: Esto no esta muy claro.. 
        for (MetamodelCoordinate coord : connector.getCoordinates()) {
            Point p = dcDiagramFactory.createPoint();
            p.setX(coord.getX());
            p.setY(coord.getY());
            edge.getWaypoint().add(p);
        }
        return diagramFactory.createBPMNEdge(edge);
    }

    private JAXBElement<BPMNShape> createShape(MetamodelElement element) {
        MetamodelFlowElement flowElement = (MetamodelFlowElement) element;
        BPMNShape shape = diagramFactory.createBPMNShape();
        shape.setId("BPMNShape_sid-" + flowElement.getId());
        shape.setBpmnElement(new QName(flowElement.getId())); //TODO: Esto no esta muy claro.. 
        // Bounds bound = new Bounds();
        Bounds bound = dcDiagramFactory.createBounds();
        bound.setHeight(flowElement.getHeight());
        bound.setWidth(flowElement.getWidth());
        bound.setX(flowElement.getCoordinate().getX());
        bound.setY(flowElement.getCoordinate().getY());
        shape.setBounds(bound);

        return diagramFactory.createBPMNShape(shape);
    }

    private JAXBElement<? extends TGateway> createGateWay(MetamodelGateway element) {

        TGateway bpmnGateWay;
        JAXBElement<? extends TGateway> jaxbGateWay;
        if (isInclusiveGateway(element)) {
            TInclusiveGateway gate = modelFactory.createTInclusiveGateway();
            //TODO: Propiedades especificas de Inclusive Gateways
            bpmnGateWay = gate;
            jaxbGateWay = modelFactory.createInclusiveGateway(gate);
        } else if (isParallelGateway(element)) {
            TParallelGateway gate = modelFactory.createTParallelGateway();
            //TODO: Propiedades especificas de Parallel Gateways
            bpmnGateWay = gate;
            jaxbGateWay = modelFactory.createParallelGateway(gate);
        } else {
            bpmnGateWay = modelFactory.createTGateway();
            jaxbGateWay = modelFactory.createGateway(bpmnGateWay);
        }
        bpmnGateWay.setId(element.getId());
        bpmnGateWay.setName(element.getName());
        return jaxbGateWay;

    }

    private JAXBElement<TStartEvent> createStartEvent(MetamodelStartEvent event) {
        TStartEvent startEvent = modelFactory.createTStartEvent();
        startEvent.setId(event.getId());
        startEvent.setName(event.getName());
        return modelFactory.createStartEvent(startEvent);
    }

    private JAXBElement<TEndEvent> createEndEvent(MetamodelEndEvent event) {
        TEndEvent endEvent = modelFactory.createTEndEvent();
        endEvent.setId(event.getId());
        endEvent.setName(event.getName());
        return modelFactory.createEndEvent(endEvent);
    }

    private JAXBElement<TSequenceFlow> createSequenceFlow(MetamodelSequenceFlow sequence) {
        TSequenceFlow sequenceFlow = modelFactory.createTSequenceFlow();
        sequenceFlow.setId(sequence.getId());
        TFlowElement referenced = bpmnElements.get(sequence.getFrom().getId());
        if (referenced == null)
            throw new IllegalArgumentException("From Element of bpmn connector " + sequence.getId() + " is null");
        sequenceFlow.setSourceRef(referenced);  // Aca no va el id, sino que va el objeto referenciado! :)

        referenced = bpmnElements.get(sequence.getTo().getId());
        if (referenced == null)
            throw new IllegalArgumentException("To Element of bpmn connector " + sequence.getId() + " is null");
        sequenceFlow.setTargetRef(referenced);    // Aca no va el id, sino que va el objeto referenciado! :)
        return modelFactory.createSequenceFlow(sequenceFlow);
    }

    private JAXBElement<? extends TTask> createTask(MetamodelTask task) {
        TTask bpmnTask = null;
        JAXBElement<? extends TTask> jaxbtask;
        if (isManualTask(task)) {
            TUserTask t = modelFactory.createTUserTask();
            //TODO: Propiedades especificas de user tasks
            bpmnTask = t;
            jaxbtask = modelFactory.createUserTask(t);
        } else if (isUserTask(task)) {
            TManualTask t = modelFactory.createTManualTask();
            //TODO: Propiedades especificas de un manual tasks
            bpmnTask = t;
            jaxbtask = modelFactory.createManualTask(t);
        } else {
            bpmnTask = modelFactory.createTTask();
            jaxbtask = modelFactory.createTask(bpmnTask);
        }
        switch (task.getLoop()) {
        case Multi:
            bpmnTask.setLoopCharacteristics(modelFactory.createLoopCharacteristics(modelFactory
                    .createTMultiInstanceLoopCharacteristics()));
            break;
        case Standard:
            bpmnTask.setLoopCharacteristics(modelFactory.createLoopCharacteristics(modelFactory
                    .createTStandardLoopCharacteristics()));
            break;
        default:
            // En bpmn si el loop es none parece que no lleva nada.
            break;
        }
        bpmnTask.setId(task.getId());
        bpmnTask.setName(task.getName());
        return jaxbtask;
    }
}