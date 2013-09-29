package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelIntermediateSignalThrow extends MetamodelIntermediate {

    private String triggerResult;

    public MetamodelIntermediateSignalThrow(String id, String name, String description, double x, double y,
            double width, double height, String lane, boolean adj, String ref, String triggerResult) {
        super(id, name, description, x, y, width, height, lane, adj, ref);
        this.triggerResult = triggerResult;
    }

    public String getTriggerResult() {
        return triggerResult;
    }

    public void setTriggerResult(String triggerResult) {
        this.triggerResult = triggerResult;
    }

}
