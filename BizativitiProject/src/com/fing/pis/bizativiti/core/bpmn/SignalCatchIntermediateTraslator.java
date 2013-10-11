package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TIntermediateCatchEvent;
import org.omg.spec.bpmn._20100524.model.TSignalEventDefinition;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateSignalCatch;

public class SignalCatchIntermediateTraslator extends ATranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelIntermediate catchevent = (MetamodelIntermediate) o;

        TIntermediateCatchEvent signalevent = e.getModelFactory().createTIntermediateCatchEvent();
        signalevent.setId(catchevent.getId());
        signalevent.setName(catchevent.getName());
        if (catchevent.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(catchevent.getDescription());
            signalevent.getDocumentation().add(documentation);
        }

        MetamodelIntermediateSignalCatch signalEevent = (MetamodelIntermediateSignalCatch) o;
        TSignalEventDefinition signal = e.getModelFactory().createTSignalEventDefinition();
        if (signalEevent.getTriggerResult() != null) {
            QName mRef = new QName("signalRef");
            signal.getOtherAttributes().put(mRef, signalEevent.getTriggerResult());
        }
        JAXBElement<? extends TSignalEventDefinition> signalRef = e.getModelFactory().createSignalEventDefinition(
                signal);

        signalevent.getEventDefinition().add(signalRef);

        return e.getModelFactory().createIntermediateCatchEvent(signalevent);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
