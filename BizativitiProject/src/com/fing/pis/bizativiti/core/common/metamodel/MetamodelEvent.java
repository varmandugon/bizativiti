package com.fing.pis.bizativiti.core.common.metamodel;


public abstract class MetamodelEvent extends MetamodelFlowElement {

    private String lane;

    public MetamodelEvent(String id, String name, String description, double x, double y, double width, double height, String lane) {
        super(id, name, description, x, y, width, height);
        if (lane == null) {
            throw new NullPointerException("lane can't be null");
        }
        this.lane = lane;
    }

    public String getLane() {
        return lane;
    }

}