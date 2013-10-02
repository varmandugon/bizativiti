package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.Description;
import org.wfmc._2009.xpdl2.Documentation;
import org.wfmc._2009.xpdl2.Event;
import org.wfmc._2009.xpdl2.MessageType;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.StartEvent;
import org.wfmc._2009.xpdl2.TriggerResultMessage;
import org.wfmc._2009.xpdl2.TriggerTimer;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTimerStartEvent;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;
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

        //Evento
        Event event = new Event();
        //agrego startEvent al event
        event.setStartEvent(startE);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");

        //Documentation
        Documentation doc = new Documentation();

        //Coordinates
        Coordinates coord = new Coordinates();
        coord.setXCoordinate(2.1);
        coord.setYCoordinate(3.2);

        //NodeGraphicsInfo
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("BizAgi_Process_Modeler");
        node.setCoordinates(coord);

        //NodeGraphicsInfos
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();
        nodeGraph.getNodeGraphicsInfo().add(node);

        //agrego evento y la descr al content de activity
        act.getContent().add(desc);
        act.getContent().add(event);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorStartEvent translator = new TranslatorStartEvent();
        List<MetamodelElement> items = translator.translate(f, startE, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelStartEvent.class, item.getClass());
        MetamodelStartEvent event2 = (MetamodelStartEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
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

        //Documentation
        Documentation doc = new Documentation();

        //Coordinates
        Coordinates coord = new Coordinates();
        coord.setXCoordinate(2.1);
        coord.setYCoordinate(3.2);

        //NodeGraphicsInfo
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("BizAgi_Process_Modeler");
        node.setCoordinates(coord);

        //NodeGraphicsInfos
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();
        nodeGraph.getNodeGraphicsInfo().add(node);

        //agrego evento y la descr al content de activity
        act.getContent().add(desc);
        act.getContent().add(event);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
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
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
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

        //Documentation
        Documentation doc = new Documentation();

        //Coordinates
        Coordinates coord = new Coordinates();
        coord.setXCoordinate(2.1);
        coord.setYCoordinate(3.2);

        //NodeGraphicsInfo
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("BizAgi_Process_Modeler");
        node.setCoordinates(coord);

        //NodeGraphicsInfos
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();
        nodeGraph.getNodeGraphicsInfo().add(node);

        //agrego evento y la descr al content de activity
        act.getContent().add(desc);
        act.getContent().add(event);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
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
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
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

        //Documentation
        Documentation doc = new Documentation();

        //Coordinates
        Coordinates coord = new Coordinates();
        coord.setXCoordinate(2.1);
        coord.setYCoordinate(3.2);

        //NodeGraphicsInfo
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("BizAgi_Process_Modeler");
        node.setCoordinates(coord);

        //NodeGraphicsInfos
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();
        nodeGraph.getNodeGraphicsInfo().add(node);

        //agrego evento y la descr al content de activity
        act.getContent().add(desc);
        act.getContent().add(event);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(event);
        pathFromRoot.add(startE);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
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
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
    }
}