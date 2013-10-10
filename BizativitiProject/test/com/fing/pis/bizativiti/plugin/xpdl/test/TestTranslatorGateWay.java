package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.Description;
import org.wfmc._2009.xpdl2.Documentation;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.Route;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelEventBasedGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelExclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelInclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelParallelGateway;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;
import com.fing.pis.bizativiti.plugin.xpdl.TranslatorGateWay;

public class TestTranslatorGateWay {

    /*<Activity Id="79a700fb-f2f6-4496-ad99-abec265e238a" Name="">
    <Description />
    <Route GatewayType="Parallel" />
    <Documentation />
    <NodeGraphicsInfos>
      <NodeGraphicsInfo ToolId="BizAgi_Process_Modeler" Height="40" Width="40" BorderColor="-5855715" FillColor="-52">
        <Coordinates XCoordinate="279" YCoordinate="102" />
      </NodeGraphicsInfo>
    </NodeGraphicsInfos>
    <ExtendedAttributes />
    </Activity>*/

    @Test
    public void testGatewayParallel() {
        /***** CREO UN GATEWAY *****/
        //activity
        Activity act = new Activity();
        act.setId("79a700fb-f2f6-4496-ad99-abec265e238a");
        act.setName("actividadPrueba");

        //Gateway
        Route rout = new Route();
        rout.setGatewayType("Parallel");

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
        act.getContent().add(rout);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(rout);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorGateWay translator = new TranslatorGateWay();
        List<MetamodelElement> items = translator.translate(f, rout, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelParallelGateway.class, item.getClass());
        MetamodelParallelGateway gate = (MetamodelParallelGateway) item;
        assertEquals("79a700fb-f2f6-4496-ad99-abec265e238a", gate.getId());
        assertEquals("actividadPrueba", gate.getName());
        assertEquals("descripcionn", gate.getDescription());
        assertEquals(2.1, gate.getCoordinate().getX(), 0);
        assertEquals(3.2, gate.getCoordinate().getY(), 0);
        assertEquals(6.0, gate.getWidth(), 0);
        assertEquals(5.0, gate.getHeight(), 0);

    }

    @Test
    public void testGatewayExclusive() {
        /***** CREO UN GATEWAY *****/
        //activity
        Activity act = new Activity();
        act.setId("79a700fb-f2f6-4496-ad99-abec265e238a");
        act.setName("actividadPrueba");

        //Gateway
        Route rout = new Route();
        //rout.setGatewayType("Parallel");

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
        act.getContent().add(rout);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(rout);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorGateWay translator = new TranslatorGateWay();
        List<MetamodelElement> items = translator.translate(f, rout, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelExclusiveGateway.class, item.getClass());
        MetamodelExclusiveGateway gate = (MetamodelExclusiveGateway) item;
        assertEquals("79a700fb-f2f6-4496-ad99-abec265e238a", gate.getId());
        assertEquals("actividadPrueba", gate.getName());
        assertEquals("descripcionn", gate.getDescription());
        assertEquals(2.1, gate.getCoordinate().getX(), 0);
        assertEquals(3.2, gate.getCoordinate().getY(), 0);
        assertEquals(6.0, gate.getWidth(), 0);
        assertEquals(5.0, gate.getHeight(), 0);

    }

    @Test
    public void testGatewayEventBased() {
        /***** CREO UN GATEWAY *****/
        //activity
        Activity act = new Activity();
        act.setId("79a700fb-f2f6-4496-ad99-abec265e238a");
        act.setName("actividadPrueba");

        //Gateway
        Route rout = new Route();
        rout.setExclusiveType("Event");
        //setGatewayType("Event");

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
        act.getContent().add(rout);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(rout);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorGateWay translator = new TranslatorGateWay();
        List<MetamodelElement> items = translator.translate(f, rout, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelEventBasedGateway.class, item.getClass());
        MetamodelEventBasedGateway gate = (MetamodelEventBasedGateway) item;
        assertEquals("79a700fb-f2f6-4496-ad99-abec265e238a", gate.getId());
        assertEquals("actividadPrueba", gate.getName());
        assertEquals("descripcionn", gate.getDescription());
        assertEquals(2.1, gate.getCoordinate().getX(), 0);
        assertEquals(3.2, gate.getCoordinate().getY(), 0);
        assertEquals(6.0, gate.getWidth(), 0);
        assertEquals(5.0, gate.getHeight(), 0);

    }

    @Test
    public void testGatewayInclusive() {
        /***** CREO UN GATEWAY *****/
        //activity
        Activity act = new Activity();
        act.setId("79a700fb-f2f6-4496-ad99-abec265e238a");
        act.setName("actividadPrueba");

        //Gateway
        Route rout = new Route();
        //rout.setExclusiveType("Event");
        rout.setGatewayType("Inclusive");

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
        act.getContent().add(rout);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(rout);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorGateWay translator = new TranslatorGateWay();
        List<MetamodelElement> items = translator.translate(f, rout, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelInclusiveGateway.class, item.getClass());
        MetamodelInclusiveGateway gate = (MetamodelInclusiveGateway) item;
        assertEquals("79a700fb-f2f6-4496-ad99-abec265e238a", gate.getId());
        assertEquals("actividadPrueba", gate.getName());
        assertEquals("descripcionn", gate.getDescription());
        assertEquals(2.1, gate.getCoordinate().getX(), 0);
        assertEquals(3.2, gate.getCoordinate().getY(), 0);
        assertEquals(6.0, gate.getWidth(), 0);
        assertEquals(5.0, gate.getHeight(), 0);

    }

    @Test
    public void testGatewayExclusiveData() {
        /***** CREO UN GATEWAY *****/
        //activity
        Activity act = new Activity();
        act.setId("79a700fb-f2f6-4496-ad99-abec265e238a");
        act.setName("actividadPrueba");

        //Gateway
        Route rout = new Route();
        rout.setExclusiveType("Data");
        //rout.setGatewayType("Inclusive");

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
        act.getContent().add(rout);
        act.getContent().add(doc);
        act.getContent().add(nodeGraph);

        //creo la lista de padres 
        List<Object> pathFromRoot = new ArrayList<Object>();
        pathFromRoot.add(act);
        pathFromRoot.add(rout);

        ParserConverter f = null; //se lo pasa por parametro, pero no se usa
        TranslatorGateWay translator = new TranslatorGateWay();
        List<MetamodelElement> items = translator.translate(f, rout, pathFromRoot);

        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelExclusiveGateway.class, item.getClass());
        MetamodelExclusiveGateway gate = (MetamodelExclusiveGateway) item;
        assertEquals("79a700fb-f2f6-4496-ad99-abec265e238a", gate.getId());
        assertEquals("actividadPrueba", gate.getName());
        assertEquals("descripcionn", gate.getDescription());
        assertEquals(2.1, gate.getCoordinate().getX(), 0);
        assertEquals(3.2, gate.getCoordinate().getY(), 0);
        assertEquals(6.0, gate.getWidth(), 0);
        assertEquals(5.0, gate.getHeight(), 0);

    }

}
