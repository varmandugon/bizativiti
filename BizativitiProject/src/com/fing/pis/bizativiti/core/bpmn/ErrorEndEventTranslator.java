package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TEndEvent;
import org.omg.spec.bpmn._20100524.model.TErrorEventDefinition;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelErrorEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;

public class ErrorEndEventTranslator extends ATranslator {

    // @Override
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

        MetamodelErrorEndEvent error = (MetamodelErrorEndEvent) o;
        TErrorEventDefinition errorEvent = e.getModelFactory().createTErrorEventDefinition();
        if (error.getResult() != null) {
            QName errorRef = new QName("errorRef");
            errorEvent.getOtherAttributes().put(errorRef, error.getResult());
        }
        JAXBElement<? extends TErrorEventDefinition> result = e.getModelFactory()
                .createErrorEventDefinition(errorEvent);

        endEvent.getEventDefinition().add(result);

        return e.getModelFactory().createEndEvent(endEvent);

    }

    // @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
