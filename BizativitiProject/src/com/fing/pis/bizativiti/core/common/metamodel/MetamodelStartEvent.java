package com.fing.pis.bizativiti.core.common.metamodel;

public class MetamodelStartEvent extends MetamodelEvent {

    public MetamodelStartEvent(String id, String name, String description, double x, double y, double width, double height, String lane) {
        super(id, name, description, x, y, width, height, lane);
    }

}