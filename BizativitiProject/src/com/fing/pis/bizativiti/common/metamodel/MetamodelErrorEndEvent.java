package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelErrorEndEvent extends MetamodelEvent {

    private String result;
    private String errorCode;

    public MetamodelErrorEndEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String sResult, String sErrorCode) {
        super(id, name, description, x, y, width, height, lane);
        setResult(sResult);
        setErrorCode(sErrorCode);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}