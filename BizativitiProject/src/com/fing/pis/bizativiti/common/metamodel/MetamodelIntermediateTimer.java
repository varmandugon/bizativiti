package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelIntermediateTimer extends MetamodelIntermediate {

    private String triggerType;
    private String triggerAttr;

    public MetamodelIntermediateTimer(String id, String name, String description, double x, double y, double width,
            double height, String lane, boolean adj, String ref, String triggerType, String triggerAttr) {
        super(id, name, description, x, y, width, height, lane, adj, ref);
        this.triggerType = triggerType;
        this.triggerAttr = triggerAttr;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getTriggerAttr() {
        return triggerAttr;
    }

    public void setTriggerAttr(String triggerAttr) {
        this.triggerAttr = triggerAttr;
    }

}
