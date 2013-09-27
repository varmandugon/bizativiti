package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelTimerStartEvent;

public class MetamodelTimerStartEventTest {

    private double xy = 3;
    private double hw = 1;

    @Test
    public void testLoad() throws Exception {
        MetamodelTimerStartEvent timerStartEvent = new MetamodelTimerStartEvent("85440c4a-5cad-4e7e-96af-e1240da74a34",
                "Evento de Inicio", "Descripcion del evento de inicio", 3, 3, 1, 1, "Lane del evento de inicio",
                "Timer", "TimeDate", "2013-09-25T00:00:00");

        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", timerStartEvent.getId());
        assertEquals("Evento de Inicio", timerStartEvent.getName());
        assertEquals("Descripcion del evento de inicio", timerStartEvent.getDescription());
        setXy(timerStartEvent.getCoordinate().getX());
        setXy(timerStartEvent.getCoordinate().getY());
        setHw(timerStartEvent.getHeight());
        setHw(timerStartEvent.getWidth());
        assertEquals("Timer", timerStartEvent.getTrigger());
        assertEquals("TimeDate", timerStartEvent.getTriggeType());
        assertEquals("2013-09-25T00:00:00", timerStartEvent.getTriggerAttr());

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