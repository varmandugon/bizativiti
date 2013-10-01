package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateSignalCatch;

public class MetamodelIntermediateSignalCatchTest {

    @Test
    public void testLoad() throws Exception {
        MetamodelIntermediateSignalCatch signalCatch = new MetamodelIntermediateSignalCatch(
                "4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", "Evento intermedio signalcatch", "Descripcion", 3, 3, 1, 1,
                "Lane del evento de inicio", false, "", "result");
        //public MetamodelIntermediateSignalCatch(String id, String name, String description, double x, double y,
        //double width, double height, String lane, boolean adj, String ref, String triggerResult)

        assertEquals("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", signalCatch.getId());
        assertEquals("Lane del evento de inicio", signalCatch.getLane());
        assertEquals("Evento intermedio signalcatch", signalCatch.getName());
        assertEquals("Descripcion", signalCatch.getDescription());
        assertEquals(false, signalCatch.isAdjunto());
        assertEquals("result", signalCatch.getTriggerResult());

    }

}
