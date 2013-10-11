package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TIntermediateThrowEvent;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;

public class IntermediateTranslator extends ATranslator {

    // @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelIntermediate trowevent = (MetamodelIntermediate) o;

        TIntermediateThrowEvent event = e.getModelFactory().createTIntermediateThrowEvent();
        event.setId(trowevent.getId());
        event.setName(trowevent.getName());
        if (trowevent.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(trowevent.getDescription());
            event.getDocumentation().add(documentation);
        }
        return e.getModelFactory().createIntermediateThrowEvent(event);
    }

    //@Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
