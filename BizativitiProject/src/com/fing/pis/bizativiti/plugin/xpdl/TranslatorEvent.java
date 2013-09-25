package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.core.common.metamodel.MetamodelStartEvent;

public class TranslatorEvent extends ATranslator {

    // TODO: aquí debemos ver que tipo de event estamos manejando.
    // Los datos relacionados al event se encuentran en el padre del elemento
    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.Event event = (org.wfmc._2009.xpdl2.Event) node;
        MetamodelElement item;
        // obtenemos los datos del evento explorando el padre del elemento
        org.wfmc._2009.xpdl2.Activity parent = (org.wfmc._2009.xpdl2.Activity) pathFromRoot
                .get(pathFromRoot.size() - 2);

        // obtenemos los elementos necesarios para el evento
        String id = Util.getId(parent);
        String name = Util.getName(parent);
        String description = Util.getDescription(parent);
        double x = 0; // TODO
        double y = 0; // TODO
        double width = 0; // TODO
        double height = 0; // TODO
        String lane = ""; // TODO

        // vemos que tipo de evento estamos tratando
        if (event.getStartEvent() != null) {
            item = new MetamodelStartEvent(id, name, description, x, y, width, height, lane);
        } else if (event.getIntermediateEvent() != null) {
            throw new RuntimeException("IntermediateEvent not implemented yet");
        } else if (event.getEndEvent() != null) {
            item = new MetamodelEndEvent(id, name, description, x, y, width, height, lane);
        } else {
            throw new RuntimeException("No events inside Event tag");
        }
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        result.add(item);
        return result;
    }

}