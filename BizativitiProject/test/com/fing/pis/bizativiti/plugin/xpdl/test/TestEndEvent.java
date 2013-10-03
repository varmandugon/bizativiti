package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.Description;
import org.wfmc._2009.xpdl2.Documentation;
import org.wfmc._2009.xpdl2.EndEvent;
import org.wfmc._2009.xpdl2.Event;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.ResultError;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelErrorEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTerminateEndEvent;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;
import com.fing.pis.bizativiti.plugin.xpdl.events.TranslatorEndEvent;

public class TestEndEvent {

    @Test
    public void testEndEvent() throws Exception {

        /***** CREO UN END EVENT *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        EndEvent end = new EndEvent();
        end.setResult("None");

        //Evento
        Event event = new Event();
        event.setEndEvent(end);
        act.getContent().add(event);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");
        act.getContent().add(desc);

        //Documentation
        Documentation doc = new Documentation();
        act.getContent().add(doc);

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

        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);

        //--
        pathFromRoot.add(event);
        pathFromRoot.add(end);
        //--

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorEndEvent translator = new TranslatorEndEvent();

        List<MetamodelElement> items = translator.translate(f, end, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelEndEvent.class, item.getClass());
        MetamodelEndEvent event2 = (MetamodelEndEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
        assertEquals("None", event2.getResult());
    }

    @Test
    public void testErrorEndEvent() throws Exception {

        /***** CREO UN END EVENT *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        EndEvent end = new EndEvent();
        end.setResult("Error");
        ResultError resError = new ResultError();
        resError.setErrorCode("error125");
        end.setResultError(resError);

        //Evento
        Event event = new Event();
        event.setEndEvent(end);
        act.getContent().add(event);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");
        act.getContent().add(desc);

        //Documentation
        Documentation doc = new Documentation();
        act.getContent().add(doc);

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

        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);

        //--
        pathFromRoot.add(event);
        pathFromRoot.add(end);
        //--

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorEndEvent translator = new TranslatorEndEvent();

        List<MetamodelElement> items = translator.translate(f, end, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelErrorEndEvent.class, item.getClass());
        MetamodelErrorEndEvent event2 = (MetamodelErrorEndEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
        assertEquals("Error", event2.getResult());
        assertEquals("error125", event2.getErrorCode());
    }

    @Test
    public void testTerminateEndEvent() throws Exception {

        /***** CREO UN END EVENT *****/
        //activity
        Activity act = new Activity();
        act.setId("95b04499-8a9e-447c-82b9-b244167bad35");
        act.setName("actividadPrueba");

        //startEvent
        EndEvent end = new EndEvent();
        end.setResult("Terminate");

        //Evento
        Event event = new Event();
        event.setEndEvent(end);
        act.getContent().add(event);

        //Descripcion
        Description desc = new Description();
        desc.setValue("descripcionn");
        act.getContent().add(desc);

        //Documentation
        Documentation doc = new Documentation();
        act.getContent().add(doc);

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

        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);

        //--
        pathFromRoot.add(event);
        pathFromRoot.add(end);
        //--

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorEndEvent translator = new TranslatorEndEvent();

        List<MetamodelElement> items = translator.translate(f, end, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelTerminateEndEvent.class, item.getClass());
        MetamodelTerminateEndEvent event2 = (MetamodelTerminateEndEvent) item;
        assertEquals("95b04499-8a9e-447c-82b9-b244167bad35", event2.getId());
        assertEquals("actividadPrueba", event2.getName());
        assertEquals("descripcionn", event2.getDescription());
        assertEquals(2.1, event2.getCoordinate().getX(), 0);
        assertEquals(3.2, event2.getCoordinate().getY(), 0);
        assertEquals(6.0, event2.getWidth(), 0);
        assertEquals(5.0, event2.getHeight(), 0);
        assertEquals("BizAgi_Process_Modeler", event2.getLane());
        assertEquals("Terminate", event2.getResult());
    }

}
