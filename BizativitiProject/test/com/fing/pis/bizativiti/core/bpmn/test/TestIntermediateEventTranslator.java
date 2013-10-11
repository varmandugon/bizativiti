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
import org.omg.spec.bpmn._20100524.model.TIntermediateCatchEvent;
import org.omg.spec.bpmn._20100524.model.TIntermediateThrowEvent;

import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateMessageCatch;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateSignalCatch;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateSignalThrow;
import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateTimer;
import com.fing.pis.bizativiti.core.bpmn.IntermediateTranslator;
import com.fing.pis.bizativiti.core.bpmn.MessageCatchIntermediateTranslator;
import com.fing.pis.bizativiti.core.bpmn.SignalCatchIntermediateTraslator;
import com.fing.pis.bizativiti.core.bpmn.SignalThrowIntermediateTraslator;
import com.fing.pis.bizativiti.core.bpmn.TimerIntermediateTranslator;
import com.fing.pis.bizativiti.core.bpmn.TranslatorState;

public class TestIntermediateEventTranslator {

    @Test
    public void testIntermediate() throws Exception {

        MetamodelIntermediate intermediateevent = new MetamodelIntermediate("95b04499-8a9e-447c-82b9-b244167bad35",
                "IntermediateEvent", "description", 5, 5, 2, 2, "", false, null);
        IntermediateTranslator ti = new IntermediateTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> intermediatejaxb = ti.getFlowElement(intermediateevent, e);

        assertEquals(TIntermediateThrowEvent.class, intermediatejaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", intermediatejaxb.getValue().getId());
        assertEquals("IntermediateEvent", intermediatejaxb.getValue().getName());
        List<TDocumentation> documentation = intermediatejaxb.getValue().getDocumentation();
        assertEquals("description", documentation.get(0).getContent().get(0));

    }

    @Test
    public void testTimerIntermediate() throws Exception {

        MetamodelIntermediate timerintermediate = new MetamodelIntermediateTimer(
                "95b04499-8a9e-447c-82b9-b244167bad35", "timerIntermediate", "description", 5, 5, 2, 2, "", false,
                null, "TimeCycle", "R1/PT10M");
        TimerIntermediateTranslator inttim = new TimerIntermediateTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> intermediatetimerjaxb = inttim.getFlowElement(timerintermediate, e);

        assertEquals(TIntermediateCatchEvent.class, intermediatetimerjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", intermediatetimerjaxb.getValue().getId());
        assertEquals("timerIntermediate", intermediatetimerjaxb.getValue().getName());
        List<TDocumentation> documentation = intermediatetimerjaxb.getValue().getDocumentation();
        assertEquals("description", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(intermediatetimerjaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Test
    public void testMessageCatchIntermediate() throws Exception {

        MetamodelIntermediate messageIntermediate = new MetamodelIntermediateMessageCatch(
                "95b04499-8a9e-447c-82b9-b244167bad35", "MessageCatchIntermediateEvent", "description", 5, 5, 2, 2, "",
                false, null, "messID");
        MessageCatchIntermediateTranslator intmes = new MessageCatchIntermediateTranslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> intermediatemesjaxb = intmes.getFlowElement(messageIntermediate, e);

        assertEquals(TIntermediateCatchEvent.class, intermediatemesjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", intermediatemesjaxb.getValue().getId());
        assertEquals("MessageCatchIntermediateEvent", intermediatemesjaxb.getValue().getName());
        List<TDocumentation> documentation = intermediatemesjaxb.getValue().getDocumentation();
        assertEquals("description", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(intermediatemesjaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Test
    public void testSignalCatchIntermediate() throws Exception {

        MetamodelIntermediateSignalCatch signal2 = new MetamodelIntermediateSignalCatch(
                "95b04499-8a9e-447c-82b9-b244167bad35", "SignalCatchIntermediateEvent", "dsc", 5, 5, 2, 2, "lane",
                false, null, null);
        SignalCatchIntermediateTraslator sc = new SignalCatchIntermediateTraslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> signalcatchjaxb = sc.getFlowElement(signal2, e);

        assertEquals(TIntermediateCatchEvent.class, signalcatchjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", signalcatchjaxb.getValue().getId());
        assertEquals("SignalCatchIntermediateEvent", signalcatchjaxb.getValue().getName());
        List<TDocumentation> documentation = signalcatchjaxb.getValue().getDocumentation();
        assertEquals("dsc", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TFlowElement.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            // marshaller.marshal(signalcatchjaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Test
    public void testSignalThrowIntermediate() throws Exception {

        MetamodelIntermediateSignalThrow signal = new MetamodelIntermediateSignalThrow(
                "95b04499-8a9e-447c-82b9-b244167bad35", "SignalThrowIntermediateEvent", "description", 5, 5, 2, 2,
                "lane", false, null, "triggerResult");
        SignalThrowIntermediateTraslator st = new SignalThrowIntermediateTraslator();
        TranslatorState e = new TranslatorState();
        JAXBElement<? extends TFlowElement> signalthrowjaxb = st.getFlowElement(signal, e);

        assertEquals(TIntermediateThrowEvent.class, signalthrowjaxb.getValue().getClass());
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", signalthrowjaxb.getValue().getId());
        assertEquals("SignalThrowIntermediateEvent", signalthrowjaxb.getValue().getName());
        List<TDocumentation> documentation = signalthrowjaxb.getValue().getDocumentation();
        assertEquals("description", documentation.get(0).getContent().get(0));

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(TIntermediateThrowEvent.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Mostramos el documento XML generado por la salida estandar
            //marshaller.marshal(signalthrowjaxb, System.out);

        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}
