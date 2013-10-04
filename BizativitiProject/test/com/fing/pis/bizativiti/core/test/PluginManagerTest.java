/**
 * 
 */
package com.fing.pis.bizativiti.core.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fing.pis.bizativiti.common.IPlugin;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.core.PluginManager;

/**
 * @author madli_000
 * 
 */
public class PluginManagerTest {

    public static class PluingClass1 implements IPlugin {

        @Override
        public String getType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<MetamodelElement> parse(InputStream stream) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public static class PluingClass2 implements IPlugin {

        @Override
        public String getType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<MetamodelElement> parse(InputStream stream) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public static class PluingClass3 implements IPlugin {

        @Override
        public String getType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<MetamodelElement> parse(InputStream stream) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}

    /**
     * Test method for
     * {@link com.fing.pis.bizativiti.core.PluginManager#register(java.lang.Class)}
     * .
     */
    @Test
    public final void testRegister() {
        PluginManager manager = new PluginManager();
        manager.register(PluingClass1.class, PluingClass1.class.getName());
        manager.register(PluingClass1.class, PluingClass2.class.getName());
        manager.register(PluingClass1.class, PluingClass3.class.getName());

        Map<String, Class<? extends IPlugin>> listaEsperada = new HashMap<String, Class<? extends IPlugin>>();
        listaEsperada.put(PluingClass1.class.getName(), PluingClass1.class);
        listaEsperada.put(PluingClass2.class.getName(), PluingClass2.class);
        listaEsperada.put(PluingClass3.class.getName(), PluingClass3.class);

        Map<String, Class<? extends IPlugin>> listaCargada = manager.getPlugins();

        for (String s : listaEsperada.keySet()) {
            assertTrue("No contiene elemento", listaCargada.containsKey(s));
        }

        assertTrue("No tiene registrado la misma cantidad de elementos.", listaCargada.size() == listaEsperada.size());

    }

    /**
     * Test method for
     * {@link com.fing.pis.bizativiti.core.PluginManager#getPlugin(java.lang.String)}
     * .
     */
    @Test
    public final void testGetPlugin() {
        PluginManager manager = new PluginManager();
        manager.register(PluingClass1.class, PluingClass1.class.getName());
        manager.register(PluingClass1.class, PluingClass2.class.getName());
        manager.register(PluingClass1.class, PluingClass3.class.getName());

        IPlugin plugin1 = null;
        try {
            plugin1 = manager.getPlugin(PluingClass1.class.getName());
        } catch (InstantiationException | IllegalAccessException e) {
            fail("Error al obtener nueva instancia del plugin");
        }

        IPlugin plugin2 = null;
        try {
            plugin2 = manager.getPlugin(PluingClass1.class.getName());
        } catch (InstantiationException | IllegalAccessException e) {
            fail("Error al obtener nueva instancia del plugin");
        }
        assertNotNull("Plugin devuelto no esta instanciado", plugin1);
        assertNotNull("Plugin devuelto no esta instanciado", plugin2);

        assertNotSame("No retorno nueva instancia.", plugin1, plugin2);

    }

    /**
     * Test method for
     * {@link com.fing.pis.bizativiti.core.PluginManager#scan(java.io.InputStream)}
     * .
     */
    @Test
    public final void testScan() {
        File f = new File("resources" + File.separator + "plugins.xml");
        assertTrue("Archivo de prueba no existe", f.exists());

        PluginManager manager = new PluginManager();

        try {
            InputStream inStream = new FileInputStream(f);
            manager.scan(inStream);
            assertTrue(manager.getPlugins().size() == 1);
            assertTrue(manager.getPluginNames().size() == 1);
            assertTrue(manager.getPluginNames().contains("XPDL"));

        } catch (ClassNotFoundException | JAXBException | XMLStreamException | IOException e) {
            fail(e.getStackTrace().toString());
        }
    }

}
