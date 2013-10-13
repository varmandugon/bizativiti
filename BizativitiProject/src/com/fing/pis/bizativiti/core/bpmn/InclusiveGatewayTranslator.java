package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TInclusiveGateway;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelInclusiveGateway;

public class InclusiveGatewayTranslator extends ATranslator {

    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelInclusiveGateway element = (MetamodelInclusiveGateway) o;

        TInclusiveGateway gate = e.getModelFactory().createTInclusiveGateway();
        gate.setId(element.getId());
        gate.setName(element.getName());
        if (element.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(element.getDescription());
            gate.getDocumentation().add(documentation);
        }

        return e.getModelFactory().createInclusiveGateway(gate);
    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {

        return Helper.createShape((MetamodelFlowElement) o);
    }

}
