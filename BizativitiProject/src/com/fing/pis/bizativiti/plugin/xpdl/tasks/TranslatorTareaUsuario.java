package com.fing.pis.bizativiti.plugin.xpdl.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.MessageType;
import org.wfmc._2009.xpdl2.Performers;
import org.wfmc._2009.xpdl2.TaskUser;
import org.wfmc._2009.xpdl2.WebServiceOperation;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTask.LoopType;
import com.fing.pis.bizativiti.common.metamodel.MetamodelUserTask;
import com.fing.pis.bizativiti.plugin.xpdl.ATranslator;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;
import com.fing.pis.bizativiti.plugin.xpdl.Util;

public class TranslatorTareaUsuario extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {

        TaskUser tareaUsuario = (TaskUser) node;
        Activity actividad = (Activity) pathFromRoot.get(pathFromRoot.size() - 3);

        // TODO: Procesar estos atributos si es necesario.

        String implementacion = tareaUsuario.getImplementation();
        Map<QName, String> atributosAdicionales = tareaUsuario.getOtherAttributes();
        List<Object> any = tareaUsuario.getAny();
        MessageType messageIn = tareaUsuario.getMessageIn();
        MessageType messageOut = tareaUsuario.getMessageOut();
        Performers actionPerformer = tareaUsuario.getPerformers();
        WebServiceOperation webServie = tareaUsuario.getWebServiceOperation();
        //---

        String id = Util.getId(actividad);
        String name = Util.getName(actividad);
        String description = Util.getDescription(actividad);

        double x = Util.getX(actividad);
        double y = Util.getY(actividad);
        double width = Util.getWidth(actividad);
        double height = Util.getHeight(actividad);
        String lane = Util.getLaneId(actividad);
        LoopType loopType = Util.getLoopTipe(actividad);

        List<MetamodelElement> result = new ArrayList<MetamodelElement>();

        MetamodelElement task = new MetamodelUserTask(id, name, description, x, y, width, height, lane, loopType);

        result.add(task);

        return result;
    }

}
