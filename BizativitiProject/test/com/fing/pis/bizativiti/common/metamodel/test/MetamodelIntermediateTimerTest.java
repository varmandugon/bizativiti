package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateTimer;

public class MetamodelIntermediateTimerTest {

    @Test
    public void testLoad() throws Exception {
        MetamodelIntermediateTimer timer = new MetamodelIntermediateTimer("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4",
                "Evento intermedio timer", "Descripcion", 3, 3, 1, 1, "Lane del evento de inicio", false, "",
                "TimeDate", "fecha");
        // public MetamodelIntermediateTimer(String id, String name, String description, double x, double y, double width,
        //double height, String lane, boolean adj, String ref, String triggerType, String triggerAttr)

        assertEquals("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", timer.getId());
        assertEquals("Lane del evento de inicio", timer.getLane());
        assertEquals("Evento intermedio timer", timer.getName());
        assertEquals("Descripcion", timer.getDescription());
        assertEquals(false, timer.isAdjunto());
        assertEquals("fecha", timer.getTriggerAttr());
        assertEquals("TimeDate", timer.getTriggerType());

    }

}
