package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TGateway;
import org.omg.spec.bpmn._20100524.model.TInclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TParallelGateway;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelGateway;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelInclusiveGateway;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelParallelGateway;

public class GatewayTranslator implements Translator {

    @Override
    public boolean canTranslate(Object o) {
        return o instanceof MetamodelGateway;
    }

    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelGateway element = (MetamodelGateway) o;
        TGateway bpmnGateWay;
        JAXBElement<? extends TGateway> jaxbGateWay;
        if (isInclusiveGateway(element)) {
            TInclusiveGateway gate = e.getModelFactory().createTInclusiveGateway();
            //TODO: Propiedades especificas de Inclusive Gateways
            bpmnGateWay = gate;
            jaxbGateWay = e.getModelFactory().createInclusiveGateway(gate);
        } else if (isParallelGateway(element)) {
            TParallelGateway gate = e.getModelFactory().createTParallelGateway();
            //TODO: Propiedades especificas de Parallel Gateways
            bpmnGateWay = gate;
            jaxbGateWay = e.getModelFactory().createParallelGateway(gate);
        } else {
            bpmnGateWay = e.getModelFactory().createTGateway();
            jaxbGateWay = e.getModelFactory().createGateway(bpmnGateWay);
        }
        // TODO: falta exclusive gateway
        bpmnGateWay.setId(element.getId());
        bpmnGateWay.setName(element.getName());
        return jaxbGateWay;
    }

    private boolean isInclusiveGateway(MetamodelGateway element) {
        return element instanceof MetamodelInclusiveGateway;
    }

    private boolean isParallelGateway(MetamodelGateway element) {
        return element instanceof MetamodelParallelGateway;
    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}