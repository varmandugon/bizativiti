package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TExpression;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TIntermediateCatchEvent;
import org.omg.spec.bpmn._20100524.model.TTimerEventDefinition;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateTimer;

public class TimerIntermediateTranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelIntermediate catchevent = (MetamodelIntermediate) o;

        TIntermediateCatchEvent timerevent = e.getModelFactory().createTIntermediateCatchEvent();
        timerevent.setId(catchevent.getId());
        timerevent.setName(catchevent.getName());
        if (catchevent.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(catchevent.getDescription());
            timerevent.getDocumentation().add(documentation);
        }

        //agrego date o cycle
        MetamodelIntermediateTimer timerIntermediate = (MetamodelIntermediateTimer) o;
        TTimerEventDefinition timer = e.getModelFactory().createTTimerEventDefinition();

        if (timerIntermediate.getTriggerType().equals("TimeDate")) {
            TExpression exp = new TExpression();
            exp.setId(timerIntermediate.getTriggerAttr());
            timer.setTimeDate(exp);
        } else if (timerIntermediate.getTriggerType().equals("TimeCycle")) {
            TExpression exp = new TExpression();
            exp.setId(timerIntermediate.getTriggerAttr());
            timer.setTimeCycle(exp);
        }

        JAXBElement<? extends TTimerEventDefinition> dateorcycle = e.getModelFactory()
                .createTimerEventDefinition(timer);

        timerevent.getEventDefinition().add(dateorcycle);

        return e.getModelFactory().createIntermediateCatchEvent(timerevent);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
