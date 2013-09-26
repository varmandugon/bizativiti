package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelTimerStartEvent extends MetamodelEvent {
    private String trigger = null; // indica si es TimeDate o TimeCycle
    private String triggerAttr = null; // contiene el valor del timer (fecha o tiempo)

    public MetamodelTimerStartEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String sTrigger, String sTriggerAttr) {
        super(id, name, description, x, y, width, height, lane);
        setTrigger(sTrigger);
        setTriggerAttr(sTriggerAttr);
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getTriggerAttr() {
        return triggerAttr;
    }

    public void setTriggerAttr(String triggerAttr) {
        this.triggerAttr = triggerAttr;
    }

}