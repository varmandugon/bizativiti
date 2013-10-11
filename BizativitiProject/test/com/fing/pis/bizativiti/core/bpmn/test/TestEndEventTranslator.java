package com.fing.pis.bizativiti.core.bpmn.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TEndEvent;
import org.omg.spec.bpmn._20100524.model.TFlowElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelErrorEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTerminateEndEvent;
import com.fing.pis.bizativiti.core.bpmn.EndEventTranslator;
import com.fing.pis.bizativiti.core.bpmn.ErrorEndEventTranslator;
import com.fing.pis.bizativiti.core.bpmn.TerminateEndEventTranslator;
import com.fing.pis.bizativiti.core.bpmn.TranslatorState;

public class TestEndEventTranslator {

    @Test
    public void testEnd() throws Exception {

        MetamodelEndEvent endEvent = new MetamodelEndEvent("95b04499-8a9e-447c-82b9-b244167bad35", "EndEvent",
                "descripcion", 5, 5, 2, 2, "", null);

        EndEventTranslator t = new EndEventTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> startjaxb = t.getFlowElement(endEvent, e);

        assertEquals(TEndEvent.class, startjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", startjaxb.getValue().getId());
        assertEquals("EndEvent", startjaxb.getValue().getName());
        List<TDocumentation> documentation = startjaxb.getValue().getDocumentation();
        assertEquals("descripcion", documentation.get(0).getContent().get(0));

    }

    @Test
    public void testErrorEnd() throws Exception {

        MetamodelEndEvent error = new MetamodelErrorEndEvent("95b04499-8a9e-447c-82b9-b244167bad35", "errorEvent",
                "description", 5, 5, 2, 2, "", null, "errorCode");
        ErrorEndEventTranslator terr = new ErrorEndEventTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> errorjaxb = terr.getFlowElement(error, e);

        assertEquals(TEndEvent.class, errorjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", errorjaxb.getValue().getId());
        assertEquals("errorEvent", errorjaxb.getValue().getName());
        List<TDocumentation> documentation = errorjaxb.getValue().getDocumentation();
        assertEquals("description", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(errorjaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Test
    public void testTerminateEnd() throws Exception {

        MetamodelEndEvent terminate = new MetamodelTerminateEndEvent("95b04499-8a9e-447c-82b9-b244167bad35",
                "TerminateEndEvent", "description", 5, 5, 2, 2, "", "sResult");

        TerminateEndEventTranslator te = new TerminateEndEventTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> terminatejaxb = te.getFlowElement(terminate, e);

        assertEquals(TEndEvent.class, terminatejaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", terminatejaxb.getValue().getId());
        assertEquals("TerminateEndEvent", terminatejaxb.getValue().getName());
        List<TDocumentation> documentation = terminatejaxb.getValue().getDocumentation();
        assertEquals("description", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(terminatejaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}
