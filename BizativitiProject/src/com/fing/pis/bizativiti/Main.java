package com.fing.pis.bizativiti;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.wfmc._2009.xpdl2.PackageType;

import com.fing.pis.bizativiti.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.parser.BPMNWriter;
import com.fing.pis.bizativiti.parser.XPDLParser;

public class Main {

    /**
     * Funcion principal encargada de llamar: 1) XpdlFIleHandler para cargar el
     * archivo 2) XPDLParser para convertirlo a la clase commons 3) BPMNWriter
     * para pasarlo de commons a la estructura de BPMN 4) BpmnFileHandler para
     * que escriba el xml
     * 
     * Para configurar los args lo hacen con boton derecho en el proyecto
     * DebugAs->Configuration->Arguments tab
     * 
     * @param args
     *            Contiene: 1 - path al archivo xpdl
     * 
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            String xpdlPath = args[0];
            String bpmnPath = args[1];

            XPDLParser parser = new XPDLParser();
            BPMNWriter writer = new BPMNWriter();

            // Leo el xpdl
            PackageType xpdlModel = com.fing.pis.bizativiti.utils.xpdlparser.FileHandler.readFile(xpdlPath);
            System.out.println("Archivo xpdl leido.");

            //Convierto xpdl a commons
            MetamodelPackage metamodel = parser.convert(xpdlModel);
            System.out.println("XPDL -> Commons finalizado.");

            //Convierto commons a BPMN
            JAXBElement<TDefinitions> bpmnModel = writer.convert(metamodel);
            System.out.println("Commons -> BPMN finalizado.");

            //Escribo BPMN
            com.fing.pis.bizativiti.utils.bpmnwriter.FileHandler.writeFile(bpmnModel, bpmnPath);
            System.out.println("Archivo bpmn escrito.");

        } else {
            System.out.println("Falatan parametros a la llamada");
        }

    }

}
