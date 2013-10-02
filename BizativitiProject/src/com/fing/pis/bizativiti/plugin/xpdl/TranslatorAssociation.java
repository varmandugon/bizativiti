package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelAssociation;
import com.fing.pis.bizativiti.common.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorAssociation extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.Association association = (org.wfmc._2009.xpdl2.Association) node;
        List<MetamodelElement> resultList = new ArrayList<MetamodelElement>();

        String id = association.getId();
        String description = null; // FIXME: de donde se obtiene el valor??
        String to = association.getTarget();
        String from = association.getSource();
        String name = association.getName();
        List<MetamodelCoordinate> coordinates = new ArrayList<MetamodelCoordinate>();
        for (org.wfmc._2009.xpdl2.ConnectorGraphicsInfo info : association.getConnectorGraphicsInfos()
                .getConnectorGraphicsInfo()) {
            for (org.wfmc._2009.xpdl2.Coordinates coords : info.getCoordinates()) {
                coordinates.add(new MetamodelCoordinate(coords.getXCoordinate(), coords.getYCoordinate()));
            }
        }
        MetamodelAssociation result = new MetamodelAssociation(id, description, null, null, name, coordinates);

        resultList.add(result);
        return resultList;
    }

}