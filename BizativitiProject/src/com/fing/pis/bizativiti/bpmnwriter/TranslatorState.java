package com.fing.pis.bizativiti.bpmnwriter;

import java.util.HashMap;
import java.util.Map;

import org.omg.spec.bpmn._20100524.model.TFlowElement;

public class TranslatorState {

    private org.omg.spec.bpmn._20100524.model.ObjectFactory modelFactory = new org.omg.spec.bpmn._20100524.model.ObjectFactory();
    private org.omg.spec.bpmn._20100524.di.ObjectFactory diagramFactory = new org.omg.spec.bpmn._20100524.di.ObjectFactory();
    private org.omg.spec.dd._20100524.di.ObjectFactory diDiagramFactory = new org.omg.spec.dd._20100524.di.ObjectFactory();
    private org.omg.spec.dd._20100524.dc.ObjectFactory dcDiagramFactory = new org.omg.spec.dd._20100524.dc.ObjectFactory();
    private Map<String, TFlowElement> bpmnElements = new HashMap<String, TFlowElement>();

    public Map<String, TFlowElement> getElements() {
        return bpmnElements;
    }

    public org.omg.spec.bpmn._20100524.model.ObjectFactory getModelFactory() {
        return modelFactory;
    }

    public org.omg.spec.bpmn._20100524.di.ObjectFactory getDiagramFactory() {
        return diagramFactory;
    }

    public org.omg.spec.dd._20100524.di.ObjectFactory getDiDiagramFactory() {
        return diDiagramFactory;
    }

    public org.omg.spec.dd._20100524.dc.ObjectFactory getDcDiagramFactory() {
        return dcDiagramFactory;
    }

}