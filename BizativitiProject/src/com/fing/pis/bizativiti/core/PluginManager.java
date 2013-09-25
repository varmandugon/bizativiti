package com.fing.pis.bizativiti.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.fing.pis.bizativiti.common.IPlugin;

public class PluginManager {

    private Map<String, IPlugin> plugins = new HashMap<String, IPlugin>();

    /**
     * Registra un plugin en el sistema
     * 
     * @param plugin
     * @throws IllegalArgumentException
     *             si ya existe un plugin registrado que maneja el mismo tipo de
     *             archivo
     */
    public void register(IPlugin plugin) {
        if (plugin == null) {
            throw new NullPointerException("null plugin isn't valid");
        }
        IPlugin oldPlugin = plugins.get(plugin.getType());
        if (oldPlugin != null) {
            throw new IllegalArgumentException("Plugin " + oldPlugin.getClass()
                    + " already registered for handle type " + plugin.getType());
        }
        plugins.put(plugin.getType(), plugin);
    }

    /**
     * Obtiene el plugin correspondiente al tipo que se encuentra en el sistema
     * 
     * @param plugin
     * @throws IllegalArgumentException
     *             si no hay un plugin registrado para el tipo dado
     */
    public IPlugin getPlugin(String type) {
        IPlugin plugin = plugins.get(type);
        if (plugin == null) {
            throw new IllegalArgumentException("No plugin registered for type " + type);
        }
        return plugin;
    }

    /**
     * Registra los plugins referenciados en el flujo de entrada. El flujo de
     * entrada debe contener el nombre de la clase que implementa IPlugin
     * 
     * @param is
     */
    public void scan(InputStream is) {
        // TODO
    }

}