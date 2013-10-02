package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelSequenceFlow;

public class TranslatorTransition extends ATranslator {

    private static final String DEFAULT_DESCRIPTION = "";
    private static final String DEFAULT_CONDITIONTYPE = "";

    @Override
    // FIXME: por ahora los conectores son nulos hasta que se cambie el metamodelo
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.Transition transition = (org.wfmc._2009.xpdl2.Transition) node;
        List<MetamodelElement> resultList = new ArrayList<MetamodelElement>();

        String id = transition.getId();
        String description = (transition.getDescription() != null) ? transition.getDescription().getValue()
                : DEFAULT_DESCRIPTION;
        String to = transition.getTo();
        String from = transition.getFrom();
        String name = transition.getName();

        String conditionType = (transition.getCondition() != null) ? transition.getCondition().getType()
                : DEFAULT_CONDITIONTYPE;
        StringBuilder condition = new StringBuilder();
        if (transition.getCondition() != null) {
            for (Object content : transition.getCondition().getContent()) {
                if (content instanceof String) {
                    condition.append(content).append("\n");
                } else { // JAXBElement<ExpressionType>
                    // FIXME: no agregar por ahora
                }
            }
        }

        List<MetamodelCoordinate> coordinates = new ArrayList<MetamodelCoordinate>();
        if (transition.getConnectorGraphicsInfos() != null) {
            for (org.wfmc._2009.xpdl2.ConnectorGraphicsInfo info : transition.getConnectorGraphicsInfos()
                    .getConnectorGraphicsInfo()) {
                for (org.wfmc._2009.xpdl2.Coordinates coords : info.getCoordinates()) {
                    coordinates.add(new MetamodelCoordinate(coords.getXCoordinate(), coords.getYCoordinate()));
                }
            }
        }

        MetamodelSequenceFlow result = new MetamodelSequenceFlow(id, description, null, null, name, conditionType,
                condition.toString(), coordinates);

        resultList.add(result);
        return resultList;
    }
}