package com.fing.pis.bizativiti.plugin.xpdl.events;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.EndEvent;
import org.wfmc._2009.xpdl2.PackageType;
import org.wfmc._2009.xpdl2.ResultError;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelErrorEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTerminateEndEvent;
import com.fing.pis.bizativiti.plugin.xpdl.ATranslator;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;
import com.fing.pis.bizativiti.plugin.xpdl.Util;

public class TranslatorEndEvent extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {

        EndEvent event = (EndEvent) node;
        Activity parent = (Activity) pathFromRoot.get(pathFromRoot.size() - 3);
        // obtenemos los elementos necesarios para el evento
        String id = Util.getId(parent);
        String name = Util.getName(parent);
        String description = Util.getDescription(parent);

        double x = Util.getX(parent);
        double y = Util.getY(parent);
        double width = Util.getWidth(parent);
        double height = Util.getHeight(parent);
        String lane = Util.getLaneName(parent, (PackageType) pathFromRoot.get(0));

        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        // vemos que tipo de evento end estamos tratando
        String resultEvent = event.getResult();
        MetamodelEndEvent itemEndEvent = null;
        if (resultEvent.equals("Error")) {
            ResultError re = event.getResultError();
            if (re != null) {
                itemEndEvent = new MetamodelErrorEndEvent(id, name, description, x, y, width, height, lane,
                        resultEvent, re.getErrorCode());
            } else {
                itemEndEvent = new MetamodelErrorEndEvent(id, name, description, x, y, width, height, lane,
                        resultEvent, "Error Desconocido");
            }
        } else if (resultEvent.equals("None")) {
            itemEndEvent = new MetamodelEndEvent(id, name, description, x, y, width, height, lane, resultEvent);

        } else if (resultEvent.equals("Terminate")) {
            itemEndEvent = new MetamodelTerminateEndEvent(id, name, description, x, y, width, height, lane, resultEvent);
        }
        if (itemEndEvent != null) {
            result.add(itemEndEvent);
        }
        return result;
    }
}
