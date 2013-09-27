package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.common.metamodel.MetamodelErrorEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelSequenceFlow;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;

public class MetamodelSequenceFlowTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {

        MetamodelStartEvent startEvent = new MetamodelStartEvent("11111c1a-1cad-1e1e-11af-e111da11a11",
                "Evento de Inicio", "Descripcion del evento de inicio", 3, 3, 1, 1, "Lane del evento de inicio", "None");

        MetamodelErrorEndEvent errorEndEvent = new MetamodelErrorEndEvent("22222c2a-2cad-2e2e-22af-e2222da22a22",
                "Evento de error", "Descripcion del evento de inicio", 3, 3, 1, 1, "Lane del evento de error",
                "Resutl", "Codigo de Error");

        List<MetamodelCoordinate> coordinates = new ArrayList();

        MetamodelSequenceFlow sequenceFlow = new MetamodelSequenceFlow("85440c4a-5cad-4e7e-96af-e1240da74a34",
                "Descripcion del sequenceFlow", startEvent, errorEndEvent, "Nombre del sequence flow", "None", null,
                coordinates);

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", sequenceFlow.getId());
        assertEquals("Nombre del sequence flow", sequenceFlow.getName());
        assertEquals("Descripcion del sequenceFlow", sequenceFlow.getDescription());
        assertEquals("None", sequenceFlow.getConditionType());
        assertEquals(null, sequenceFlow.getCondition());
        assertEquals(startEvent, sequenceFlow.getTo());
        assertEquals(errorEndEvent, sequenceFlow.getFrom());
        assertEquals(coordinates, sequenceFlow.getCoordinates());

    }

    public double getXy() {
        return xy;
    }

    public void setXy(double xy) {
        this.xy = xy;
    }

    public double getHw() {
        return hw;
    }

    public void setHw(double hw) {
        this.hw = hw;
    }

}