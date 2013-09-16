package com.fing.pis.bizativiti.metamodel;

public abstract class MetamodelElement {

    private String id;
    private String description;

    public MetamodelElement(String id, String description) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }
        this.id = id;
        if (description == null) {
            throw new IllegalArgumentException("description is null");
        }
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}