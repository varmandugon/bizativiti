package com.fing.pis.bizativiti.common.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MetamodelPackage {

    private List<MetamodelElement> elements = new ArrayList<MetamodelElement>();
    private String name = "";
    private boolean isExecutable; // No se donde se mapea esto en xpdl

    /** Devuelve una copia de la lista de elementos en el paquete */
    public List<MetamodelElement> getElements() {
        return new ArrayList<MetamodelElement>(elements);
    }

    public void addElement(MetamodelElement element) {
        if (elements.contains(element)) {
            throw new IllegalArgumentException("Element " + element + " already exists in the package");
        }
        elements.add(element);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsExecutable() {
        return isExecutable;
    }

    public void setIsExecutable(boolean isExecutable) {
        this.isExecutable = isExecutable;
    }

}