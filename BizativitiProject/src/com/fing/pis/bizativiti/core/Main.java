package com.fing.pis.bizativiti.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import com.fing.pis.bizativiti.common.IPlugin;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;

public class Main {

    /**
     * Método principal que se encarga de convertir el flujo de entrada en BPMN.
     * 
     * @param plugins
     *            flujo que contiene las indicaciones de los plugins a cargar.
     * @param in
     *            flujo de entrada
     * @param type
     *            tipo de plugin a usarse para la conversión
     * @param out
     *            flujo de salida en BPMN
     * @throws XMLStreamException
     * @throws JAXBException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     */
    public void convert(InputStream plugins, InputStream in, String type, OutputStream out)
            throws ClassNotFoundException, JAXBException, XMLStreamException, InstantiationException,
            IllegalAccessException, IOException {
        PluginManager pm = new PluginManager();
        pm.scan(plugins);
        IPlugin plugin = pm.getPlugin(type);
        List<MetamodelElement> elements = plugin.parse(in);
        // TODO: convertir utilizando Factory de BPMN
    }

    /**
     * Punto de entrada para el cliente de linea de comandos. Ejemplo:
     * archivo_plugins tipo_plugin archivo_entrada archivo_salida
     * 
     * @param args
     */
    // FIXME: mejorar manejo de errores y parametros a usar
    public static void main(String[] args) {
        InputStream pluginsStream;
        String type;
        InputStream inStream;
        OutputStream outStream;
        try {
            pluginsStream = new FileInputStream(args[0]);
            type = args[1];
            inStream = new FileInputStream(args[2]);
            outStream = new FileOutputStream(args[3]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Main main = new Main();
        try {
            main.convert(pluginsStream, inStream, type, outStream);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            pluginsStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            inStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            outStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}