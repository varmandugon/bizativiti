package com.fing.pis.bizativiti.metamodel;

public abstract class MetamodelFlowElement extends MetamodelElement {

    private String name;
    private MetamodelCoordinate coordinate;
    private double width;
    private double height;

    public MetamodelFlowElement(String id, String name, String description, double x, double y, double width, double height) {
        super(id, description);
        if (x == -1) {
            throw new IllegalArgumentException("x value is not set");
        }
        if (y == -1) {
            throw new IllegalArgumentException("y value is not set");
        }
        coordinate = new MetamodelCoordinate(x, y);
        if (width == -1) {
            throw new IllegalArgumentException("width value is not set");
        }
        this.width = width;
        if (height == -1) {
            throw new IllegalArgumentException("height value is not set");
        }
        this.height = height;
    }

    public MetamodelCoordinate getCoordinate() {
        return coordinate;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getName() {
        return name;
    }

}