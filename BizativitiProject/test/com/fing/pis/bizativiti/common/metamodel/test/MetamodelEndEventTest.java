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
        setXy(endEvent.getCoordinate().getX());
        setXy(endEvent.getCoordinate().getY());
        setHw(endEvent.getHeight());
        setHw(endEvent.getWidth());
        assertEquals("Resutl", endEvent.getResult());

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