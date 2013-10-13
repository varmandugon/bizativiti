package com.fing.pis.bizativiti.core.bpmn.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.junit.Test;
import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TExclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TInclusiveGateway;
import org.omg.spec.bpmn._20100524.model.TParallelGateway;

import com.fing.pis.bizativiti.common.metamodel.MetamodelExclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelInclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelParallelGateway;
import com.fing.pis.bizativiti.core.bpmn.ExclusiveGatewayTranslator;
import com.fing.pis.bizativiti.core.bpmn.InclusiveGatewayTranslator;
import com.fing.pis.bizativiti.core.bpmn.ParallelGatewayTranslator;
import com.fing.pis.bizativiti.core.bpmn.TranslatorState;

public class TestGateway {

    @Test
    public void testInclusiveGateway() throws Exception {
        MetamodelInclusiveGateway m = new MetamodelInclusiveGateway("95b04499-8a9e-447c-82b9-b244167bad35",
                "InclusiveGateway", "Descripcion de InclusiveGateway", 3, 3, 1, 1);
        InclusiveGatewayTranslator ig = new InclusiveGatewayTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> gwjaxb = ig.getFlowElement(m, e);

        assertEquals(TInclusiveGateway.class, gwjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", gwjaxb.getValue().getId());
        assertEquals("InclusiveGateway", gwjaxb.getValue().getName());
        List<TDocumentation> documentation = gwjaxb.getValue().getDocumentation();
        assertEquals("Descripcion de InclusiveGateway", documentation.get(0).getContent().get(0));
    }

    @Test
    public void testExclusiveGateway() throws Exception {
        MetamodelExclusiveGateway m = new MetamodelExclusiveGateway("95b04499-8a9e-447c-82b9-b244167bad35",
                "ExclusiveGateway", "Descripcion de ExclusiveGateway", 3, 3, 1, 1);
        ExclusiveGatewayTranslator ig = new ExclusiveGatewayTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> gwjaxb = ig.getFlowElement(m, e);

        assertEquals(TExclusiveGateway.class, gwjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", gwjaxb.getValue().getId());
        assertEquals("ExclusiveGateway", gwjaxb.getValue().getName());
        List<TDocumentation> documentation = gwjaxb.getValue().getDocumentation();
        assertEquals("Descripcion de ExclusiveGateway", documentation.get(0).getContent().get(0));
    }

    @Test
    public void testParallelGateway() throws Exception {
        MetamodelParallelGateway m = new MetamodelParallelGateway("95b04499-8a9e-447c-82b9-b244167bad35",
                "ParallelGateway", "Descripcion de ParallelGateway", 3, 3, 1, 1);
        ParallelGatewayTranslator ig = new ParallelGatewayTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> gwjaxb = ig.getFlowElement(m, e);

        assertEquals(TParallelGateway.class, gwjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", gwjaxb.getValue().getId());
        assertEquals("ParallelGateway", gwjaxb.getValue().getName());
        List<TDocumentation> documentation = gwjaxb.getValue().getDocumentation();
        assertEquals("Descripcion de ParallelGateway", documentation.get(0).getContent().get(0));
    }
}
