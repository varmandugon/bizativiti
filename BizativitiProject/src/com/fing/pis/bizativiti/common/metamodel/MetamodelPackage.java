package com.fing.pis.bizativiti.common.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MetamodelPackage extends MetamodelElement {

    private List<MetamodelElement> elements = new ArrayList<MetamodelElement>();
    private String name = "";

    public MetamodelPackage(String id, String description, String name, List<MetamodelElement> elements) {
        super(id, description);
        if (name == null) {
            throw new NullPointerException("name can't be null");
        }
        this.name = name;

        if (elements == null) {
            throw new NullPointerException("elements can't be null");
        }
        this.elements.addAll(elements);
    }

    public List<MetamodelElement> getElements() {
        return new ArrayList<MetamodelElement>(elements);
    }

    public String getName() {
        return name;
    }

}