package com.fing.pis.bizativiti.metamodel;

public class MetamodelManualTask extends MetamodelTask {

    public MetamodelManualTask(String id, String name, String description, double x, double y, double width,
            double height, LoopType loop, String pool, String lane) {
        super(id, name, description, x, y, width, height, loop, pool, lane);
    }

}