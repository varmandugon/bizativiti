package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.dd._20100524.di.DiagramElement;

public abstract class ATranslator {

    public abstract JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e);

    public abstract JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e);

}