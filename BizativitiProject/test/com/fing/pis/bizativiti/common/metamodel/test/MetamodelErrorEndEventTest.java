package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelErrorEndEvent;

public class MetamodelErrorEndEventTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {
        MetamodelErrorEndEvent errorEndEvent = new MetamodelErrorEndEvent("85440c4a-5cad-4e7e-96af-e1240da74a34",
                "Evento de Inicio", "Descripcion del evento de inicio", 3, 3, 1, 1, "Lane del evento de inicio",
                "Resutl", "Codigo de Error");

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", errorEndEvent.getId());
        assertEquals("Evento de Inicio", errorEndEvent.getName());
        assertEquals("Descripcion del evento de inicio", errorEndEvent.getDescription());
        setXy(errorEndEvent.getCoordinate().getX());
        setXy(errorEndEvent.getCoordinate().getY());
        setHw(errorEndEvent.getHeight());
        setHw(errorEndEvent.getWidth());
        assertEquals("Resutl", errorEndEvent.getResult());
        assertEquals("Codigo de Error", errorEndEvent.getErrorCode());

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