package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;

public class MetamodelMessageStartEventTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {
        MetamodelMessageStartEvent messageStartEvent = new MetamodelMessageStartEvent(
                "85440c4a-5cad-4e7e-96af-e1240da74a34", "Evento de Inicio", "Descripcion del evento de inicio", 3, 3,
                1, 1, "Lane del evento de inicio", "Trigger", "Id del mensaje");

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", messageStartEvent.getId());
        assertEquals("Evento de Inicio", messageStartEvent.getName());
        assertEquals("Descripcion del evento de inicio", messageStartEvent.getDescription());
        setXy(messageStartEvent.getCoordinate().getX());
        setXy(messageStartEvent.getCoordinate().getY());
        setHw(messageStartEvent.getHeight());
        setHw(messageStartEvent.getWidth());
        assertEquals("Trigger", messageStartEvent.getTrigger());
        assertEquals("Id del mensaje", messageStartEvent.getMessageId());
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