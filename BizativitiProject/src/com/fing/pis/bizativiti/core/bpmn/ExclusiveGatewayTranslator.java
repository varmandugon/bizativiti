package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TExclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelExclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;

public class ExclusiveGatewayTranslator extends ATranslator {

    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelExclusiveGateway element = (MetamodelExclusiveGateway) o;
        TExclusiveGateway gate = e.getModelFactory().createTExclusiveGateway();
        gate.setId(element.getId());
        gate.setName(element.getName());
        if (element.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(element.getDescription());
            gate.getDocumentation().add(documentation);
        }
        return e.getModelFactory().createExclusiveGateway(gate);

    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}
