package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateSignalThrow;

public class MetamodelIntermediateSignalThrowTest {

    @Test
    public void testLoad() throws Exception {
        MetamodelIntermediateSignalThrow signalThrow = new MetamodelIntermediateSignalThrow(
                "4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", "Evento intermedio signalthrow", "Descripcion", 3, 3, 1, 1,
                "Lane del evento de inicio", false, "", "result");
        //public MetamodelIntermediateSignalThrow(String id, String name, String description, double x, double y,
        //double width, double height, String lane, boolean adj, String ref, String triggerResult)

        assertEquals("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", signalThrow.getId());
        assertEquals("Lane del evento de inicio", signalThrow.getLane());
        assertEquals("Evento intermedio signalthrow", signalThrow.getName());
        assertEquals("Descripcion", signalThrow.getDescription());
        assertEquals(false, signalThrow.isAdjunto());
        assertEquals("result", signalThrow.getTriggerResult());

    }

}
