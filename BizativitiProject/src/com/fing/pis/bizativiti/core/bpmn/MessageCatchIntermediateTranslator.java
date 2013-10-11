package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TIntermediateCatchEvent;
import org.omg.spec.bpmn._20100524.model.TMessageEventDefinition;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateMessageCatch;

public class MessageCatchIntermediateTranslator extends ATranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelIntermediate catchevent = (MetamodelIntermediate) o;

        TIntermediateCatchEvent messageevent = e.getModelFactory().createTIntermediateCatchEvent();
        messageevent.setId(catchevent.getId());
        messageevent.setName(catchevent.getName());
        if (catchevent.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(catchevent.getDescription());
            messageevent.getDocumentation().add(documentation);
        }

        MetamodelIntermediateMessageCatch messageEevent = (MetamodelIntermediateMessageCatch) o;
        TMessageEventDefinition message = e.getModelFactory().createTMessageEventDefinition();
        if (messageEevent.getMessageId() != null) {
            QName mRef = new QName("messageRef");
            message.getOtherAttributes().put(mRef, messageEevent.getMessageId());
        }
        JAXBElement<? extends TMessageEventDefinition> messageRef = e.getModelFactory().createMessageEventDefinition(
                message);

        messageevent.getEventDefinition().add(messageRef);

        return e.getModelFactory().createIntermediateCatchEvent(messageevent);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
