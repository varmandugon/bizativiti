package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelEndEvent extends MetamodelEvent {

    private String result;

    public MetamodelEndEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String result) {
        super(id, name, description, x, y, width, height, lane);
        setResult(result);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}