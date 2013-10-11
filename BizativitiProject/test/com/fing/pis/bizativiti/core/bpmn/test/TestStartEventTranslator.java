package com.fing.pis.bizativiti.core.bpmn.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TStartEvent;

import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTimerStartEvent;
import com.fing.pis.bizativiti.core.bpmn.MessageStartEventTranslator;
import com.fing.pis.bizativiti.core.bpmn.StartEventTranslator;
import com.fing.pis.bizativiti.core.bpmn.TimerStartEventTranslator;
import com.fing.pis.bizativiti.core.bpmn.TranslatorState;

public class TestStartEventTranslator {

    @Test
    public void testStart() throws Exception {

        MetamodelStartEvent m = new MetamodelStartEvent("95b04499-8a9e-447c-82b9-b244167bad35", "StartEvent",
                "descripcion", 5, 5, 2, 2, "", null);

        StartEventTranslator t = new StartEventTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> startjaxb = t.getFlowElement(m, e);

        assertEquals(TStartEvent.class, startjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", startjaxb.getValue().getId());
        assertEquals("StartEvent", startjaxb.getValue().getName());
        List<TDocumentation> documentation = startjaxb.getValue().getDocumentation();
        assertEquals("descripcion", documentation.get(0).getContent().get(0));

    }

    @Test
    public void testTimerStart() throws Exception {

        MetamodelStartEvent m = new MetamodelTimerStartEvent("95b04499-8a9e-447c-82b9-b244167bad35", "timeStartEvent",
                "descripcion", 5, 5, 2, 2, "", "Timer", "TimeDate", "R1/PT10M");

        TimerStartEventTranslator t = new TimerStartEventTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> timerjaxb = t.getFlowElement(m, e);

        assertEquals(TStartEvent.class, timerjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", timerjaxb.getValue().getId());
        assertEquals("timeStartEvent", timerjaxb.getValue().getName());
        List<TDocumentation> documentation = timerjaxb.getValue().getDocumentation();
        assertEquals("descripcion", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(timerjaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Test
    public void testMessageStart() throws Exception {

        MetamodelStartEvent message = new MetamodelMessageStartEvent("95b04499-8a9e-447c-82b9-b244167bad35",
                "messageStartEvent", "Descripcion", 5, 5, 2, 2, "", "Trigger", "Idmessage");

        MessageStartEventTranslator mt = new MessageStartEventTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> messagejaxb = mt.getFlowElement(message, e);

        assertEquals(TStartEvent.class, messagejaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", messagejaxb.getValue().getId());
        assertEquals("messageStartEvent", messagejaxb.getValue().getName());
        List<TDocumentation> documentation = messagejaxb.getValue().getDocumentation();
        assertEquals("Descripcion", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(messagejaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

}
