package com.fing.pis.bizativiti.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.fing.pis.bizativiti.common.IPlugin;

public class PluginManager {

    private Map<String, Class<? extends IPlugin>> plugins = new HashMap<String, Class<? extends IPlugin>>();

    public Map<String, Class<? extends IPlugin>> getPlugins() {
        return plugins;
    }

    public void setPlugins(Map<String, Class<? extends IPlugin>> plugins) {
        this.plugins = plugins;
    }

    /**
     * Registra un plugin en el sistema
     * 
     * @param plugin
     * @throws IllegalArgumentException
     *             si ya existe un plugin registrado que maneja el mismo tipo de
     *             archivo
     */
    public void register(Class<? extends IPlugin> plugin, String name) {
        if (plugin == null) {
            throw new NullPointerException("null plugin isn't valid");
        }
        Class<? extends IPlugin> oldPlugin = plugins.get(name);
        if (oldPlugin != null) {
            throw new IllegalArgumentException("Plugin " + oldPlugin + " already registered for handle type "
                    + plugin.getName());
        }
        plugins.put(name, plugin);
    }

    /**
     * Obtiene el plugin correspondiente al tipo que se encuentra en el sistema
     * 
     * @param plugin
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IllegalArgumentException
     *             si no hay un plugin registrado para el tipo dado
     */
    public IPlugin getPlugin(String type) throws InstantiationException, IllegalAccessException {
        Class<? extends IPlugin> pluginClass = plugins.get(type);
        if (pluginClass == null) {
            throw new IllegalArgumentException("No plugin registered for type " + type);
        }
        return pluginClass.newInstance();
    }

    /**
     * Registra los plugins referenciados en el flujo de entrada. El flujo de
     * entrada debe contener una lista clave valor por cada plugin marcando el
     * path al jar y el nombre completo (paquetes + nombre) de la clase que
     * implementa la interfaz IPlugin
     * 
     * @param is
     * @throws JAXBException
     * @throws XMLStreamException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public void scan(InputStream is) throws JAXBException, XMLStreamException, ClassNotFoundException, IOException {

        JaxbList records = readXmlFile(is);
        for (PluginRecord record : records.getRecords()) {
            if (!record.getJar().isEmpty()) {
                File myJarFile = new File(record.getJar());
                if (!myJarFile.isFile()) {
                    throw new FileNotFoundException("Missing required JAR: " + myJarFile.toString());
                }

                URLClassLoader loader = new URLClassLoader(new URL[] { myJarFile.toURI().toURL() });
                Class<? extends IPlugin> plugin = (Class<? extends IPlugin>) loader.loadClass(record.getClassName());
                register(plugin, record.getCaption());
                loader.close();
            } else {

                Class<? extends IPlugin> plugin = (Class<? extends IPlugin>) Class.forName(record.getClassName());
                register(plugin, record.getCaption());

            }
        }

    }

    private JaxbList readXmlFile(InputStream is) throws JAXBException, XMLStreamException {

        JAXBContext jc;
        jc = JAXBContext.newInstance(JaxbList.class);
        // Contexto JAXB con la clase que corresponde al root del xml
        JaxbList result = new JaxbList();
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(is);
        JAXBElement<? extends JaxbList> jaxRecords = unmarshaller.unmarshal(reader, JaxbList.class);
        // Obrenemos el elemento root del xml 
        result = jaxRecords.getValue();
        reader.close();

        return result;

    }

    /***
     * Retorna los nombre de los plugins cargados
     * 
     * @return
     */
    public Set<String> getPluginNames() {
        return plugins.keySet();
    }

}