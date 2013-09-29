package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TExpression;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TStartEvent;
import org.omg.spec.bpmn._20100524.model.TTimerEventDefinition;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTimerStartEvent;

public class TimerStartEventTranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {

        MetamodelStartEvent event = (MetamodelStartEvent) o;

        TStartEvent startEvent = e.getModelFactory().createTStartEvent();
        startEvent.setId(event.getId());
        startEvent.setName(event.getName());
        if (event.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(event.getDescription());
            startEvent.getDocumentation().add(documentation);
        }

        //agrego date o cycle
        MetamodelTimerStartEvent timerevent = (MetamodelTimerStartEvent) o;
        TTimerEventDefinition timer = e.getModelFactory().createTTimerEventDefinition();

        if (timerevent.getTriggeType().equals("TimeDate")) {
            TExpression exp = new TExpression();
            exp.setId(timerevent.getTriggerAttr());
            timer.setTimeDate(exp);
        } else if (timerevent.getTriggeType().equals("TimeCycle")) {
            TExpression exp = new TExpression();
            exp.setId(timerevent.getTriggerAttr());
            timer.setTimeCycle(exp);
        }

        JAXBElement<? extends TTimerEventDefinition> dateorcycle = e.getModelFactory()
                .createTimerEventDefinition(timer);

        startEvent.getEventDefinition().add(dateorcycle);

        return e.getModelFactory().createStartEvent(startEvent);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }
}
