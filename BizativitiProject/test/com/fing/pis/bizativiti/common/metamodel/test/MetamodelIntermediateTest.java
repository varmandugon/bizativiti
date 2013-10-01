package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediate;

public class MetamodelIntermediateTest {

    @Test
    public void testLoad() throws Exception {
        MetamodelIntermediate intermediate = new MetamodelIntermediate("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4",
                "Evento intermedio simple", "Descripcion", 3, 3, 1, 1, "Lane del evento de inicio", false, "");
        //MetamodelIntermediate(String id, String name, String description, double x, double y, double width,
        //   double height, String lane, boolean adj, String ref)

        assertEquals("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", intermediate.getId());
        assertEquals("Lane del evento de inicio", intermediate.getLane());
        assertEquals("Evento intermedio simple", intermediate.getName());
        assertEquals("Descripcion", intermediate.getDescription());
        assertEquals(false, intermediate.isAdjunto());
        assertEquals("", intermediate.getReferencia());

    }

    @Test
    public void testLoad1() throws Exception {
        MetamodelIntermediate intermediate = new MetamodelIntermediate("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4",
                "Evento intermedio simple", "Descripcion", 3, 3, 1, 1, "Lane del evento de inicio", true,
                "6fd9905a-c3cd-41a1-8889-e0208f133dd2");
        //MetamodelIntermediate(String id, String name, String description, double x, double y, double width,
        //   double height, String lane, boolean adj, String ref)

        assertEquals("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", intermediate.getId());
        assertEquals("Lane del evento de inicio", intermediate.getLane());
        assertEquals("Evento intermedio simple", intermediate.getName());
        assertEquals("Descripcion", intermediate.getDescription());
        assertEquals(true, intermediate.isAdjunto());
        assertEquals("6fd9905a-c3cd-41a1-8889-e0208f133dd2", intermediate.getReferencia());

    }

}
