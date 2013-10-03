package com.fing.pis.bizativiti.common.metamodel.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTask.LoopType;

public class MetamodelTaskTest {

    @Test
    public void test() {
        MetamodelTask task = new MetamodelTask("abe4206d-9ada-4a54-a04e-d89ce3fcb9fb", "Task 1", "descripcion de test",
                138, 142, 90, 60, "8bdf2b5a-21d1-454c-aa5b-ea5cdb6b9b3f", LoopType.None);
        assertEquals("abe4206d-9ada-4a54-a04e-d89ce3fcb9fb", task.getId());
        assertEquals("Task 1", task.getName());
        assertEquals(138, task.getCoordinate().getX(), 0);
        assertEquals(142, task.getCoordinate().getY(), 0);
        assertEquals(90, task.getWidth(), 0);
        assertEquals(60, task.getHeight(), 0);
        assertEquals("8bdf2b5a-21d1-454c-aa5b-ea5cdb6b9b3f", task.getLane());
        assertEquals(LoopType.None, task.getLoop());

    }
}
