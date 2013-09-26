package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;

public class MetamodelEndEventTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {
        MetamodelEndEvent endEvent = new MetamodelEndEvent("85440c4a-5cad-4e7e-96af-e1240da74a34", "Evento de Inicio",
                "Descripcion del evento de inicio", 3, 3, 1, 1, "Lane del evento de inicio", "Resutl");

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", endEvent.getId());
        assertEquals("Evento de Inicio", endEvent.getName());
        assertEquals("Descripcion del evento de inicio", endEvent.getDescription());
        xy = endEvent.getCoordinate().getX();
        xy = endEvent.getCoordinate().getY();
        hw = endEvent.getHeight();
        hw = endEvent.getWidth();
        assertEquals("Resutl", endEvent.getResult());

    }

}