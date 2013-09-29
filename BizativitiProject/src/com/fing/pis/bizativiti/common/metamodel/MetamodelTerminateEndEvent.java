package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelTerminateEndEvent extends MetamodelEndEvent {

    public MetamodelTerminateEndEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String result) {
        super(id, name, description, x, y, width, height, lane, result);

    }

}