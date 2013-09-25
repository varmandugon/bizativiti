package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.dd._20100524.di.DiagramElement;

public interface Translator {

    boolean canTranslate(Object o);

    JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e);

    JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e);

}