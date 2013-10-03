package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TMessageEventDefinition;
import org.omg.spec.bpmn._20100524.model.TStartEvent;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;

public class MessageStartTranslator extends ATranslator {

    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelMessageStartEvent event = (MetamodelMessageStartEvent) o;

        TStartEvent startEvent = e.getModelFactory().createTStartEvent();
        startEvent.setId(event.getId());
        startEvent.setName(event.getName());

        if (event.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(event.getDescription());
            startEvent.getDocumentation().add(documentation);
        }

        MetamodelMessageStartEvent Messageevent = (MetamodelMessageStartEvent) o;
        TMessageEventDefinition tmessage = e.getModelFactory().createTMessageEventDefinition();

        QName qn = new QName(Messageevent.getMessageId());
        tmessage.setMessageRef(qn);

        JAXBElement<? extends TMessageEventDefinition> messevent = e.getModelFactory().createMessageEventDefinition(
                tmessage);

        startEvent.getEventDefinition().add(messevent);

        return e.getModelFactory().createStartEvent(startEvent);

    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
