package com.fing.pis.bizativiti.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import com.fing.pis.bizativiti.common.IPlugin;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.core.bpmn.BPMNConverter;

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
        MetamodelPackage xpdlPackage = (MetamodelPackage) elements.get(0);
        JAXBElement<org.omg.spec.bpmn._20100524.model.TDefinitions> bpmnDefinitions = BPMNConverter
                .convert(xpdlPackage);
        BPMNConverter.writeBPMN(bpmnDefinitions, out);
    }

}