package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelIntermediate extends MetamodelEvent {

    private boolean adjunto;
    private String referencia;

    public MetamodelIntermediate(String id, String name, String description, double x, double y, double width,
            double height, String lane, boolean adj, String ref) {
        super(id, name, description, x, y, width, height, lane);
        this.adjunto = adj;
        this.referencia = ref;
    }

    public boolean isAdjunto() {
        return adjunto;
    }

    public void setAdjunto(boolean adjunto) {
        this.adjunto = adjunto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
