package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelTerminateEndEvent extends MetamodelEvent {

    private String result;

    public MetamodelTerminateEndEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String sResult) {
        super(id, name, description, x, y, width, height, lane);
        setResult(sResult);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}