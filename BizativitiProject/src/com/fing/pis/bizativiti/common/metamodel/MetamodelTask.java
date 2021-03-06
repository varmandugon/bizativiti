package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelTask extends MetamodelFlowElement {

    //FIXME: Me parece que falta agregarle implementacion o atributos adicionales. Ver para la siguiente fase.

    public enum LoopType {
        None, Standard, Multi
    };

    private String lane;
    private LoopType loop;

    public MetamodelTask(String id, String name, String description, double x, double y, double width, double height,
            String lane, LoopType loop) {
        super(id, name, description, x, y, width, height);
        this.loop = loop;
        if (lane == null) {
            throw new IllegalArgumentException("lane can't be null");
        } else {
            this.lane = lane;
        }
    }

    public LoopType getLoop() {
        return loop;
    }

    public String getLane() {
        return lane;
    }

}