package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelTimerStartEvent extends MetamodelStartEvent {
    private String triggeType = null; // indica si es TimeDate o TimeCycle
    private String triggerAttr = null; // contiene el valor del timer (fecha o tiempo)

    public MetamodelTimerStartEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String trigger, String triggeType, String triggerAttr) {
        super(id, name, description, x, y, width, height, lane, trigger);
        setTriggeType(triggeType);
        setTriggerAttr(triggerAttr);
    }

    public String getTriggeType() {
        return triggeType;
    }

    public void setTriggeType(String triggeType) {
        this.triggeType = triggeType;
    }

    public String getTriggerAttr() {
        return triggerAttr;
    }

    public void setTriggerAttr(String triggerAttr) {
        this.triggerAttr = triggerAttr;
    }

}