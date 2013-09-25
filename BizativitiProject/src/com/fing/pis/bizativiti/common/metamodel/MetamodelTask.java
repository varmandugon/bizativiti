package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelTask extends MetamodelFlowElement {

    public enum LoopType {
        None, Standard, Multi
    };

    private String pool;
    private String lane;
    private LoopType loop;

    public MetamodelTask(String id, String name, String description, double x, double y, double width, double height,
            LoopType loop, String pool, String lane) {
        super(id, name, description, x, y, width, height);
        this.loop = loop;
        if (pool == null) {
            throw new IllegalArgumentException("pool can't be null");
        }
        this.pool = pool;
        if (lane == null) {
            throw new IllegalArgumentException("lane can't be null");
        }
        this.lane = lane;

    }

    public LoopType getLoop() {
        return loop;
    }

    public String getPool() {
        return pool;
    }

    public String getLane() {
        return lane;
    }

}