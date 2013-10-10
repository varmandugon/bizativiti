package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.Association;

import com.fing.pis.bizativiti.common.metamodel.MetamodelAssociation;
import com.fing.pis.bizativiti.common.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorAssociation extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        Association association = (Association) node;
        List<MetamodelElement> resultList = new ArrayList<MetamodelElement>();

        String id = association.getId();
        String description = ""; // FIXME: de donde se obtiene el valor??
        MetamodelFlowElement to = (MetamodelFlowElement) f.getElementById(association.getTarget());
        MetamodelFlowElement from = (MetamodelFlowElement) f.getElementById(association.getSource());
        String name = association.getName();
        List<MetamodelCoordinate> coordinates = new ArrayList<MetamodelCoordinate>();
        for (org.wfmc._2009.xpdl2.ConnectorGraphicsInfo info : association.getConnectorGraphicsInfos()
                .getConnectorGraphicsInfo()) {
            for (org.wfmc._2009.xpdl2.Coordinates coords : info.getCoordinates()) {
                coordinates.add(new MetamodelCoordinate(coords.getXCoordinate(), coords.getYCoordinate()));
            }
        }
        MetamodelAssociation result = new MetamodelAssociation(id, description, to, from, name, coordinates);

        resultList.add(result);
        return resultList;
    }

}