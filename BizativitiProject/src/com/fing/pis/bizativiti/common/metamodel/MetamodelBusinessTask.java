package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelBusinessTask extends MetamodelTask {

    public MetamodelBusinessTask(String id, String name, String description, double x, double y, double width,
            double height, String lane, LoopType loop) {
        super(id, name, description, x, y, width, height, lane, loop);
    }

}
