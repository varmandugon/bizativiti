package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;

public class MetamodelStartEventTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {
        MetamodelStartEvent startEvent = new MetamodelStartEvent("85440c4a-5cad-4e7e-96af-e1240da74a34",
                "Evento de Inicio", "Descripcion del evento de inicio", 3, 3, 1, 1, "Lane del evento de inicio");

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", startEvent.getId());
        assertEquals("Evento de Inicio", startEvent.getName());
        assertEquals("Descripcion del evento de inicio", startEvent.getDescription());
        setXy(startEvent.getCoordinate().getX());
        setXy(startEvent.getCoordinate().getY());
        setHw(startEvent.getHeight());
        setHw(startEvent.getWidth());
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