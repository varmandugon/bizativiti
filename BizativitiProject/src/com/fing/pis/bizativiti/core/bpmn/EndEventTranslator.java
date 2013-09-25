package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TEndEvent;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelFlowElement;

public class EndEventTranslator implements Translator {

    @Override
    public boolean canTranslate(Object o) {
        return o instanceof MetamodelEndEvent;
    }

    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelEndEvent event = (MetamodelEndEvent) o;
        TEndEvent endEvent = e.getModelFactory().createTEndEvent();
        endEvent.setId(event.getId());
        endEvent.setName(event.getName());
        return e.getModelFactory().createEndEvent(endEvent);
    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}