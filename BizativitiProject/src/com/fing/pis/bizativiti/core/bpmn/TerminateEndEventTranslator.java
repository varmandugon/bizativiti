package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TEndEvent;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TTerminateEventDefinition;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTerminateEndEvent;

public class TerminateEndEventTranslator extends ATranslator {

    //@Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelEndEvent event = (MetamodelEndEvent) o;
        TEndEvent endEvent = e.getModelFactory().createTEndEvent();
        endEvent.setId(event.getId());
        endEvent.setName(event.getName());
        if (event.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(event.getDescription());
            endEvent.getDocumentation().add(documentation);
        }

        MetamodelTerminateEndEvent terminate = (MetamodelTerminateEndEvent) o;
        TTerminateEventDefinition terminateEvent = e.getModelFactory().createTTerminateEventDefinition();

        JAXBElement<? extends TTerminateEventDefinition> result = e.getModelFactory().createTerminateEventDefinition(
                terminateEvent);

        endEvent.getEventDefinition().add(result);

        return e.getModelFactory().createEndEvent(endEvent);

    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}