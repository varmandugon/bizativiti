package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelStartEvent extends MetamodelEvent {
    private String trigger;

    public MetamodelStartEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String trigger) {
        super(id, name, description, x, y, width, height, lane);
        setTrigger(trigger);
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

}