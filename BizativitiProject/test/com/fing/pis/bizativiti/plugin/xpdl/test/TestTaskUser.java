package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.Implementation;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.Task;
import org.wfmc._2009.xpdl2.TaskUser;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter;
import com.fing.pis.bizativiti.plugin.xpdl.DummyTranslator;
import com.fing.pis.bizativiti.plugin.xpdl.TranslatorActivity;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorImplementation;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTarea;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTareaUsuario;

public class TestTaskUser {

    @Test
    public void testTaskEvent1() {

        Activity act = new Activity();
        act.setId("11111111-1111-1111-1111-111111111111");
        act.setName("actividadUno");

        List<Object> content = act.getContent();
        Implementation impl = new Implementation();
        Task task = new Task();
        TaskUser userTask = new TaskUser();
        Coordinates coord = new Coordinates();
        NodeGraphicsInfo node = new NodeGraphicsInfo();
        NodeGraphicsInfos nodeGraph = new NodeGraphicsInfos();

        task.setTaskUser(userTask);
        impl.setTask(task);
        content.add(impl);

        coord.setXCoordinate(2.1);
        coord.setYCoordinate(3.2);

        node.setHeight(5.0);
        node.setWidth(6.0);
        node.setLaneId("BizAgi_Process_Modeler");
        node.setCoordinates(coord);

        nodeGraph.getNodeGraphicsInfo().add(node);
        content.add(nodeGraph);

        Converter converter = new Converter.Builder().add(Activity.class, new TranslatorActivity())
                .add(Implementation.class, new TranslatorImplementation()).add(Task.class, new TranslatorTarea())
                .add(TaskUser.class, new TranslatorTareaUsuario())
                .add(NodeGraphicsInfos.class, DummyTranslator.getInstance()).create();

        List<MetamodelElement> items = converter.start(act);

        assertEquals(1, items.size());

    }
}
