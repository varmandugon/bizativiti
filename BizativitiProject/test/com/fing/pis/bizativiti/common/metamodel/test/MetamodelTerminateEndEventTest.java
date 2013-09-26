package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelTerminateEndEvent;

public class MetamodelTerminateEndEventTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {
        MetamodelTerminateEndEvent terminateEndEvent = new MetamodelTerminateEndEvent(
                "85440c4a-5cad-4e7e-96af-e1240da74a34", "Evento de Inicio", "Descripcion del evento de inicio", 3, 3,
                1, 1, "Lane del evento de inicio", "Resutl");

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", terminateEndEvent.getId());
        assertEquals("Evento de Inicio", terminateEndEvent.getName());
        assertEquals("Descripcion del evento de inicio", terminateEndEvent.getDescription());
        setXy(terminateEndEvent.getCoordinate().getX());
        setXy(terminateEndEvent.getCoordinate().getY());
        setHw(terminateEndEvent.getHeight());
        setHw(terminateEndEvent.getWidth());
        assertEquals("Resutl", terminateEndEvent.getResult());

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