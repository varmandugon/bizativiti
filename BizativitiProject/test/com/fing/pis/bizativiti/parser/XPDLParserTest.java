package com.fing.pis.bizativiti.parser;

import javax.xml.bind.JAXBElement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.wfmc._2009.xpdl2.PackageType;

import com.fing.pis.bizativiti.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.utils.bpmnwriter.FileHandler;

public class XPDLParserTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConvert() {
        // test start event
        String xpdlPath = "resources/testsprototype/StartEvent.xpdl";

        XPDLParser parser = new XPDLParser();
        BPMNWriter writer = new BPMNWriter();

        // Leo el xpdl
        PackageType xpdlModel = com.fing.pis.bizativiti.utils.xpdlparser.FileHandler.readFile(xpdlPath);

        //Convierto xpdl a commons
        MetamodelPackage metamodel = parser.convert(xpdlModel);

        //Convierto commons a BPMN
        JAXBElement<TDefinitions> bpmnModel = writer.convert(metamodel);

        //Escribo BPMN a la salida estandar
        FileHandler.writeBPMN(bpmnModel);
    }

}
