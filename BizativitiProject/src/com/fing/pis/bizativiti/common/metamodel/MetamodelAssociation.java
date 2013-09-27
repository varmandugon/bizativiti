package com.fing.pis.bizativiti.common.metamodel;

import java.util.List;

public class MetamodelAssociation extends MetamodelConnector {

    public MetamodelAssociation(String id, String description, MetamodelFlowElement to, MetamodelFlowElement from,
            String name, List<MetamodelCoordinate> coordinates) {
        super(id, description, to, from, name, coordinates);
    }

}