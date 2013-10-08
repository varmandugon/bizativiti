package com.fing.pis.bizativiti.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class CLI {

    private static final String PARAM_PLUGINS = "plugin-list";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_INPUT = "input";
    private static final String PARAM_OUTPUT = "output";

    /**
     * Punto de entrada para el cliente de linea de comandos. Ejemplo:
     * archivo_plugins tipo_plugin archivo_entrada archivo_salida
     * 
     * @param args
     */
    public static void main(String[] args) {
        // new Main().convert(plugins, in, type, out);
        OptionParser parser = new OptionParser();
        parser.accepts(PARAM_PLUGINS, "Plugins definition file").withRequiredArg()
                .describedAs("plugins_definition_file").isRequired();
        parser.accepts(PARAM_TYPE, "Plugin for use").withRequiredArg().describedAs("plugins_to_use").isRequired();
        parser.accepts(PARAM_INPUT, "Input file").withRequiredArg().describedAs("input_file").isRequired();
        parser.accepts(PARAM_OUTPUT, "Output file").withRequiredArg().describedAs("output_file").isRequired();
        OptionSet options = parser.parse(args);
        if (!(options.has(PARAM_PLUGINS) && options.has(PARAM_TYPE) && options.has(PARAM_INPUT) && options
                .has(PARAM_OUTPUT))) {
            try {
                parser.printHelpOn(System.out);
            } catch (IOException e) {
                // ignore
            }
            return;
        }

        String plugins = (String) options.valueOf(PARAM_PLUGINS);
        InputStream pluginsStream;
        try {
            pluginsStream = new FileInputStream(plugins);
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file " + plugins);
            return;
        }

        String type = (String) options.valueOf(PARAM_TYPE);

        String input = (String) options.valueOf(PARAM_INPUT);
        InputStream inStream;
        try {
            inStream = new FileInputStream(input);
        } catch (FileNotFoundException e) {
            closeAll(pluginsStream);
            System.out.println("Can't open file " + input);
            return;
        }

        String output = (String) options.valueOf(PARAM_OUTPUT);
        OutputStream outStream;
        try {
            outStream = new FileOutputStream(output);
        } catch (FileNotFoundException e) {
            closeAll(pluginsStream, inStream);
            System.out.println("Can't create file " + output);
            return;
        }

        Main main = new Main();
        try {
            main.convert(pluginsStream, inStream, type, outStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(pluginsStream, inStream);
            closeAll(outStream);
        }
        System.out.println("DONE");
    }

    private static void closeAll(InputStream... streams) {
        for (InputStream stream : streams) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    private static void closeAll(OutputStream... streams) {
        for (OutputStream stream : streams) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }

    }

}