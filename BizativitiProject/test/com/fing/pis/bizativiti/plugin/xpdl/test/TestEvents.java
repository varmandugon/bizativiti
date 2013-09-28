package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Description;
import org.wfmc._2009.xpdl2.Event;
import org.wfmc._2009.xpdl2.MessageType;
import org.wfmc._2009.xpdl2.StartEvent;
import org.wfmc._2009.xpdl2.TriggerResultMessage;
import org.wfmc._2009.xpdl2.TriggerTimer;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTimerStartEvent;
import com.fing.pis.bizativiti.plugin.xpdl.Converter;
import com.fing.pis.bizativiti.plugin.xpdl.TranslatorStartEvent;

public class TestEvents {

    @Test
    public void testStartEvent() throws Exception {

        /***** CREO UN START EVENT *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        StartEvent startE = new StartEvent();
        startE.setTrigger("None");

        // startE.setTriggerTimer(trigger);

        //Evento
        Event event = new Event();
        //agrego startEvent al event
        event.setStartEvent(startE);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");

        //agrego evento y la descr al content de activity
        act.getContent().add(act);
        act.getContent().add(desc);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        Converter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorStartEvent translator = new TranslatorStartEvent();
        List<MetamodelElement> items = translator.translate(f, startE, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelStartEvent.class, item.getClass());
        MetamodelStartEvent event2 = (MetamodelStartEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
    }

    @Test
    public void testTimeStartEventTimeDate() throws Exception {

        /***** CREO UN TIME START EVENT: TIME DATE *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        StartEvent startE = new StartEvent();
        startE.setTrigger("Timer");

        //TriggerTimer
        TriggerTimer trigger = new TriggerTimer();
        //agrego triggerTimer al startEvent
        trigger.setTimeDateAttr("2013-09-210T00:00:00");
        startE.setTriggerTimer(trigger);

        //Evento
        Event event = new Event();
        //agrego startEvent al event
        event.setStartEvent(startE);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");

        //agrego evento y la descripcion al content de activity
        act.getContent().add(act);
        act.getContent().add(desc);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        Converter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorStartEvent translator = new TranslatorStartEvent();
        List<MetamodelElement> items = translator.translate(f, startE, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelTimerStartEvent.class, item.getClass());
        MetamodelTimerStartEvent event2 = (MetamodelTimerStartEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals("Timer", event2.getTrigger());
        assertEquals("2013-09-210T00:00:00", event2.getTriggerAttr());
        assertEquals("TimeDate", event2.getTriggeType());

    }

    @Test
    public void testTimeStartEventTimeCycle() throws Exception {

        /***** CREO UN TIME START EVENT: TIME CYCLE *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        StartEvent startE = new StartEvent();
        startE.setTrigger("Timer");

        //
        TriggerTimer trigger = new TriggerTimer();
        //agrego triggerTimer al startEvent
        trigger.setTimeCycleAttr("R1/PT10M");
        startE.setTriggerTimer(trigger);

        //Evento
        Event event = new Event();
        //agrego startEvent al event
        event.setStartEvent(startE);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");

        //agrego evento y la descripcion al content de activity
        act.getContent().add(act);
        act.getContent().add(desc);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        Converter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorStartEvent translator = new TranslatorStartEvent();
        List<MetamodelElement> items = translator.translate(f, startE, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelTimerStartEvent.class, item.getClass());
        MetamodelTimerStartEvent event2 = (MetamodelTimerStartEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals("Timer", event2.getTrigger());
        assertEquals("R1/PT10M", event2.getTriggerAttr());
        assertEquals("TimeCycle", event2.getTriggeType());
    }

    @Test
    public void testMessageStartEvent() throws Exception {

        /***** CREO UN MESSAGE START EVENT *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        StartEvent startE = new StartEvent();
        startE.setTrigger("Message");

        //TriggerResultMessage
        TriggerResultMessage trigger = new TriggerResultMessage();

        //Message
        MessageType message = new MessageType();
        message.setId("b131b0f3-ae5e-40ec-8677-98ee58608498");

        //Agrego message al trigger
        trigger.setMessage(message);

        //Agrego triggerMenssageResult al startEvent
        startE.setTriggerResultMessage(trigger);

        //Evento
        Event event = new Event();
        //agrego startEvent al event
        event.setStartEvent(startE);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");

        //agrego evento y la descripcion al content de activity
        act.getContent().add(act);
        act.getContent().add(desc);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        Converter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorStartEvent translator = new TranslatorStartEvent();
        List<MetamodelElement> items = translator.translate(f, startE, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelMessageStartEvent.class, item.getClass());
        MetamodelMessageStartEvent event2 = (MetamodelMessageStartEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals("Message", event2.getTrigger());
        assertEquals("b131b0f3-ae5e-40ec-8677-98ee58608498", event2.getMessageId());
    }
}