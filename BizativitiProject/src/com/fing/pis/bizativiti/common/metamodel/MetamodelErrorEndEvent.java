package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelErrorEndEvent extends MetamodelEndEvent {

    private String errorCode;

    public MetamodelErrorEndEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String result, String errorCode) {
        super(id, name, description, x, y, width, height, lane, result);
        setErrorCode(errorCode);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}