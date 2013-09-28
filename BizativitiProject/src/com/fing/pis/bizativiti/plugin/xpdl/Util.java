package com.fing.pis.bizativiti.plugin.xpdl;

import org.wfmc._2009.xpdl2.StartEvent;
import org.wfmc._2009.xpdl2.TriggerResultMessage;
import org.wfmc._2009.xpdl2.TriggerTimer;

/**
 * Clase con métodos auxiliares utilizados por los translators
 */
public class Util {

    private Util() {}

    public static String getDescription(org.wfmc._2009.xpdl2.Activity activity) {
        for (Object child : activity.getContent()) {
            if (child instanceof org.wfmc._2009.xpdl2.Description) {
                return ((org.wfmc._2009.xpdl2.Description) child).getValue();
            }
        }
        throw new RuntimeException("Description not found in activity");
    }

    public static String getId(org.wfmc._2009.xpdl2.Activity activity) {
        return activity.getId();
    }

    public static String getName(org.wfmc._2009.xpdl2.Activity activity) {
        return activity.getName();
    }

    //------

    public static String getTriggerAttrTimer(StartEvent event) {
        TriggerTimer trigger = event.getTriggerTimer();
        String sTriggerAttr = null;
        if (trigger.getTimeDateAttr() != null) {
            sTriggerAttr = trigger.getTimeDateAttr();
        } else if (trigger.getTimeCycleAttr() != null) {
            sTriggerAttr = trigger.getTimeCycleAttr();
        } else {
            throw new RuntimeException("No attributes inside TriggerTimer tag");
        }
        return sTriggerAttr;
    }

    public static String getTriggerType(StartEvent event) {
        TriggerTimer trigger = event.getTriggerTimer();
        String sTriggerType = null;
        if (trigger.getTimeDateAttr() != null) {
            sTriggerType = "TimeDate";
        } else if (trigger.getTimeCycleAttr() != null) {
            sTriggerType = "TimeCycle";
        } else {
            throw new RuntimeException("No attributes inside TriggerTimer tag");
        }
        return sTriggerType;
    }

    public static String getMessageId(StartEvent event) {
        TriggerResultMessage triggerResult = event.getTriggerResultMessage();
        if (triggerResult != null) {
            if (triggerResult.getMessage() != null) {
                return triggerResult.getMessage().getId();
            } else {
                throw new RuntimeException("No attributes inside Message tag");
            }
        } else {
            throw new RuntimeException("No attributes inside TriggerResultMessage tag");
        }
    }

}