package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.ExpressionType;
import org.wfmc._2009.xpdl2.Implementation;
import org.wfmc._2009.xpdl2.Loop;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.Task;
import org.wfmc._2009.xpdl2.TaskScript;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelScriptTask;
import com.fing.pis.bizativiti.plugin.xpdl.Converter;
import com.fing.pis.bizativiti.plugin.xpdl.DummyTranslator;
import com.fing.pis.bizativiti.plugin.xpdl.TranslatorActivity;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorImplementation;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTask;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskScript;

public class TestTaskScript {

    @Test
    public void testTaskScript1() {

        Activity act = new Activity();
        act.setId("11111111-1111-1111-1111-111111111111");
        act.setName("actividadUno");

        List<Object> content = act.getContent();
        Implementation impl = new Implementation();
        Task task = new Task();
        TaskScript scriptTask = new TaskScript();

        Coordinates coord = new Coordinates();
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();

        ExpressionType expr = new ExpressionType();
        expr.setScriptGrammar("Javascript");
        expr.setScriptType("Bash");
        expr.setScriptVersion("1.0");

        scriptTask.setScript(expr);

        task.setTaskScript(scriptTask);
        impl.setTask(task);
        content.add(impl);

        Loop l = new Loop();
        l.setLoopType("None");
        content.add(l);

        coord.setXCoordinate(3.14);
        coord.setYCoordinate(2.37);

        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("Lane");
        node.setCoordinates(coord);

        nodeGraph.getNodeGraphicsInfo().add(node);
        content.add(nodeGraph);

        Converter converter = new Converter.Builder().add(Activity.class, new TranslatorActivity())
                .add(Implementation.class, new TranslatorImplementation()).add(Task.class, new TranslatorTask())
                .add(TaskScript.class, new TranslatorTaskScript())
                .add(NodeGraphicsInfos.class, DummyTranslator.getInstance())
                .add(Loop.class, DummyTranslator.getInstance()).create();

        List<MetamodelElement> items = converter.start(act);

        assertEquals(1, items.size());
        assertEquals(true, items.get(0) instanceof MetamodelScriptTask);
        MetamodelScriptTask me = (MetamodelScriptTask) items.get(0);
        assertEquals("11111111-1111-1111-1111-111111111111", me.getId());
        assertEquals("actividadUno", me.getName());
        assertEquals("", me.getDescription());

        assertEquals("Lane", me.getLane());
        assertEquals("None", me.getLoop().toString());
        assertEquals(5.0, me.getHeight(), 0);
        assertEquals(6.0, me.getWidth(), 0);
        assertEquals(3.14, me.getCoordinate().getX(), 0);
        assertEquals(2.37, me.getCoordinate().getY(), 0);

    }
}
