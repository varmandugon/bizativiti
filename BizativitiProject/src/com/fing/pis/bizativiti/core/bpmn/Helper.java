package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.di.BPMNEdge;
import org.omg.spec.bpmn._20100524.di.BPMNShape;
import org.omg.spec.dd._20100524.dc.Bounds;
import org.omg.spec.dd._20100524.dc.Point;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelConnector;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelFlowElement;

public class Helper {

    private static org.omg.spec.bpmn._20100524.model.ObjectFactory modelFactory = new org.omg.spec.bpmn._20100524.model.ObjectFactory();
    private static org.omg.spec.bpmn._20100524.di.ObjectFactory diagramFactory = new org.omg.spec.bpmn._20100524.di.ObjectFactory();
    private static org.omg.spec.dd._20100524.di.ObjectFactory diDiagramFactory = new org.omg.spec.dd._20100524.di.ObjectFactory();
    private static org.omg.spec.dd._20100524.dc.ObjectFactory dcDiagramFactory = new org.omg.spec.dd._20100524.dc.ObjectFactory();
    public static String SHAPEID_PREFIX = "BPMNShape_sid-";
    public static String EDGEID_PREFIX = "BPMNEdge_sid-";

    private Helper() {}

    public static JAXBElement<BPMNShape> createShape(MetamodelFlowElement flowElement) {
        BPMNShape shape = diagramFactory.createBPMNShape();
        shape.setId(SHAPEID_PREFIX + flowElement.getId());
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

    public static JAXBElement<BPMNEdge> createEdge(MetamodelConnector connector) {
        BPMNEdge edge = diagramFactory.createBPMNEdge();
        edge.setId(EDGEID_PREFIX + connector.getId());
        edge.setBpmnElement(new QName(connector.getId())); //TODO: Esto no esta muy claro.. 
        for (MetamodelCoordinate coord : connector.getCoordinates()) {
            Point p = dcDiagramFactory.createPoint();
            p.setX(coord.getX());
            p.setY(coord.getY());
            edge.getWaypoint().add(p);
        }
        return diagramFactory.createBPMNEdge(edge);
    }

}