package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelSequenceFlow;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorTransition extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.Transition transition = (org.wfmc._2009.xpdl2.Transition) node;
        List<MetamodelElement> resultList = new ArrayList<MetamodelElement>();

        String id = transition.getId();
        String description = transition.getDescription().getValue();
        MetamodelFlowElement to = (MetamodelFlowElement) f.getElementById(transition.getTo());
        MetamodelFlowElement from = (MetamodelFlowElement) f.getElementById(transition.getFrom());
        String name = transition.getName();

        String conditionType = transition.getCondition().getType();
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

        MetamodelSequenceFlow result = new MetamodelSequenceFlow(id, description, to, from, name, conditionType,
                condition.toString(), coordinates);

        resultList.add(result);
        return resultList;
    }

}