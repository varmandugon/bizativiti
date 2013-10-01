package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelIntermediateMessageCatch;

public class MetamodelIntermediateMessageCatchTest {

    @Test
    public void testLoad() throws Exception {
        MetamodelIntermediateMessageCatch message = new MetamodelIntermediateMessageCatch(
                "4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", "Evento intermedio messagecatch", "Descripcion", 3, 3, 1, 1,
                "Lane del evento de inicio", false, "", "5e5f3586-ca0a-48d5-831a-582ced1804b2");
        //public MetamodelIntermediateMessageCatch(String id, String name, String description, double x, double y,
        // double width, double height, String lane, boolean adj, String ref, String messID)

        assertEquals("4aafc39b-21ae-4fb8-95bc-b5c92da45ac4", message.getId());
        assertEquals("Lane del evento de inicio", message.getLane());
        assertEquals("Evento intermedio messagecatch", message.getName());
        assertEquals("Descripcion", message.getDescription());
        assertEquals(false, message.isAdjunto());
        assertEquals("", message.getReferencia());
        assertEquals("5e5f3586-ca0a-48d5-831a-582ced1804b2", message.getMessageId());

    }

}
