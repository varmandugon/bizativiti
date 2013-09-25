package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelSequenceFlow extends MetamodelConnector {

    public MetamodelSequenceFlow(String id, String description, MetamodelFlowElement to, MetamodelFlowElement from) {
        super(id, description, to, from);
    }

}