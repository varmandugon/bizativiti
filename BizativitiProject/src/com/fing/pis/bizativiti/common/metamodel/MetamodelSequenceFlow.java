package com.fing.pis.bizativiti.common.metamodel;

import java.util.List;

public class MetamodelSequenceFlow extends MetamodelConnector {

    private String conditionType; // si es null es xq no tiene ninguna condicion y cunado se llama al constructor se lo llama con "None"
    private String condition; // si conditionType = CONDITION entonces esto es distinto de null

    public MetamodelSequenceFlow(String id, String description, MetamodelFlowElement to, MetamodelFlowElement from,
            String name, String conditionType, String condition, List<MetamodelCoordinate> coordinates) {
        super(id, description, to, from, name, coordinates);
        setConditionType(conditionType);
        setCondition(condition);
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}