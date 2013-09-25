package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.plugin.xpdl.Facade;

public class TranslatorTest {

    @Test
    public void testLoad() throws Exception {
        InputStream is = new FileInputStream("resources/startevent.xpdl");
        Facade xpdlPlugin = new Facade();
        List<MetamodelElement> items = xpdlPlugin.parse(is);
        assertEquals(1, items.size());
        MetamodelElement item = items.get(0);
        assertEquals(MetamodelStartEvent.class, item.getClass());
        MetamodelStartEvent event = (MetamodelStartEvent) item;
        assertEquals("85440c4a-5cad-4e7e-96af-e1240da74a34", event.getId());
        assertEquals("", event.getName());
        assertEquals("", event.getDescription());
    }

}