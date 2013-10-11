package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TIntermediateThrowEvent;
import org.omg.spec.bpmn._20100524.model.TSignalEventDefinition;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateSignalThrow;

public class SignalThrowIntermediateTraslator extends ATranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelIntermediate trowevent = (MetamodelIntermediate) o;

        TIntermediateThrowEvent signalevent = e.getModelFactory().createTIntermediateThrowEvent();
        signalevent.setId(trowevent.getId());
        signalevent.setName(trowevent.getName());
        if (trowevent.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(trowevent.getDescription());
            signalevent.getDocumentation().add(documentation);
        }

        MetamodelIntermediateSignalThrow signalEevent = (MetamodelIntermediateSignalThrow) o;
        TSignalEventDefinition signal = e.getModelFactory().createTSignalEventDefinition();
        if (signalEevent.getTriggerResult() != null) {
            QName mRef = new QName("signalRef");
            signal.getOtherAttributes().put(mRef, signalEevent.getTriggerResult());
        }
        JAXBElement<? extends TSignalEventDefinition> signalRef = e.getModelFactory().createSignalEventDefinition(
                signal);

        signalevent.getEventDefinition().add(signalRef);

        return e.getModelFactory().createIntermediateThrowEvent(signalevent);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
