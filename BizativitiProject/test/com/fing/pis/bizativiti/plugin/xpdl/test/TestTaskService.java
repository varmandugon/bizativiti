package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.ExpressionType;
import org.wfmc._2009.xpdl2.Implementation;
import org.wfmc._2009.xpdl2.MessageType;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.Task;
import org.wfmc._2009.xpdl2.TaskService;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelServiceTask;
import com.fing.pis.bizativiti.plugin.xpdl.Converter;
import com.fing.pis.bizativiti.plugin.xpdl.DummyTranslator;
import com.fing.pis.bizativiti.plugin.xpdl.TranslatorActivity;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorImplementation;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTarea;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTareaServicio;

public class TestTaskService {

    @Test
    public void testTaskService1() {

        Activity act = new Activity();
        act.setId("11111111-1111-1111-1111-111111111111");
        act.setName("actividadUno");

        List<Object> content = act.getContent();
        Implementation impl = new Implementation();
        Task task = new Task();
        TaskService serviceTask = new TaskService();

        Coordinates coord = new Coordinates();
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();

        ExpressionType expr = new ExpressionType();
        expr.setScriptGrammar("Javascript");
        expr.setScriptType("Bash");
        expr.setScriptVersion("1.0");

        serviceTask.setImplementation("Impl");
        MessageType mt = new MessageType();
        mt.setFaultName("NombreCompleto");
        mt.setFrom("De");
        mt.setId("id");
        mt.setName("Nombre");
        mt.setTo("Para");

        serviceTask.setMessageIn(mt);
        serviceTask.setMessageOut(mt);

        task.setTaskService(serviceTask);
        impl.setTask(task);
        content.add(impl);

        coord.setXCoordinate(3.14);
        coord.setYCoordinate(2.37);

        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("Lane");
        node.setCoordinates(coord);

        nodeGraph.getNodeGraphicsInfo().add(node);
        content.add(nodeGraph);

        Converter converter = new Converter.Builder().add(Activity.class, new TranslatorActivity())
                .add(Implementation.class, new TranslatorImplementation()).add(Task.class, new TranslatorTarea())
                .add(TaskService.class, new TranslatorTareaServicio())
                .add(NodeGraphicsInfos.class, DummyTranslator.getInstance()).create();

        List<MetamodelElement> items = converter.start(act);

        assertEquals(1, items.size());
        assertEquals(true, items.get(0) instanceof MetamodelServiceTask);
        MetamodelServiceTask me = (MetamodelServiceTask) items.get(0);
        assertEquals("11111111-1111-1111-1111-111111111111", me.getId());
        assertEquals("actividadUno", me.getName());
        assertEquals("", me.getDescription());

        assertEquals("Lane", me.getLane());

        assertEquals(5.0, me.getHeight(), 0);
        assertEquals(6.0, me.getWidth(), 0);
        assertEquals(3.14, me.getCoordinate().getX(), 0);
        assertEquals(2.37, me.getCoordinate().getY(), 0);

    }
}
