package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTimerStartEvent;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorStartEvent extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.StartEvent event = (org.wfmc._2009.xpdl2.StartEvent) node;
        org.wfmc._2009.xpdl2.Activity parent = (org.wfmc._2009.xpdl2.Activity) pathFromRoot
                .get(pathFromRoot.size() - 3);
        // obtenemos los elementos necesarios para el evento
        String id = Util.getId(parent);
        String name = Util.getName(parent);
        String description = Util.getDescription(parent);

        double x = Util.getX(parent);
        double y = Util.getY(parent);
        double width = Util.getWidth(parent);
        double height = Util.getHeight(parent);
        String lane = Util.getLaneId(parent);

        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        // vemos que tipo de evento inicio estamos tratando
        String sTrigger = event.getTrigger();
        if (sTrigger == "None") {
            MetamodelStartEvent itemStartEvent = new MetamodelStartEvent(id, name, description, x, y, width, height,
                    lane, sTrigger);
            result.add(itemStartEvent);
        } else if (sTrigger == "Timer") {
            String triggerType = Util.getTriggerType(event);
            String sTriggerAttr = Util.getTriggerAttrTimer(event);
            MetamodelTimerStartEvent itemTimerStart = new MetamodelTimerStartEvent(id, name, description, x, y, width,
                    height, lane, sTrigger, triggerType, sTriggerAttr);
            result.add(itemTimerStart);
        } else if (sTrigger == "Message") {
            String sMessageId = Util.getMessageId(event);
            MetamodelMessageStartEvent itemMessageStart = new MetamodelMessageStartEvent(id, name, description, x, y,
                    width, height, lane, sTrigger, sMessageId);
            result.add(itemMessageStart);
        } else {
            throw new RuntimeException("No Events inside StartEvents tag");
        }

        return result;
    }
}