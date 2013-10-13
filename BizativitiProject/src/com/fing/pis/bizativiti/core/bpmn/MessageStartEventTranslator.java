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
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.plugin.xpdl.Util;

public class MessageStartEventTranslator extends ATranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelStartEvent event = (MetamodelStartEvent) o;

        TStartEvent startEvent = e.getModelFactory().createTStartEvent();
        startEvent.setId(event.getId());
        startEvent.setName(event.getName());
        if (event.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(Util.getPlainTextFromHTML(event.getDescription()));
            startEvent.getDocumentation().add(documentation);
        }

        MetamodelMessageStartEvent messageEevent = (MetamodelMessageStartEvent) o;
        TMessageEventDefinition message = e.getModelFactory().createTMessageEventDefinition();
        if (messageEevent.getMessageId() != null) {
            QName mRef = new QName("messageRef");
            message.getOtherAttributes().put(mRef, messageEevent.getMessageId());
        }
        JAXBElement<? extends TMessageEventDefinition> messageRef = e.getModelFactory().createMessageEventDefinition(
                message);

        startEvent.getEventDefinition().add(messageRef);

        return e.getModelFactory().createStartEvent(startEvent);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
