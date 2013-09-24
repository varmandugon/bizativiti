package com.fing.pis.bizativiti.bpmnwriter;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TStartEvent;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.metamodel.MetamodelStartEvent;

public class StartEventTranslator implements Translator {

    @Override
    public boolean canTranslate(Object o) {
        return o instanceof MetamodelStartEvent;
    }

    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelStartEvent event = (MetamodelStartEvent) o;

        TStartEvent startEvent = e.getModelFactory().createTStartEvent();
        startEvent.setId(event.getId());
        startEvent.setName(event.getName());
        return e.getModelFactory().createStartEvent(startEvent);
    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}