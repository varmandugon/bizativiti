package com.fing.pis.bizativiti.parser;

import javax.xml.bind.JAXBElement;

import org.junit.Test;
import org.omg.spec.bpmn._20100524.di.BPMNDiagram;
import org.omg.spec.bpmn._20100524.di.BPMNPlane;
import org.omg.spec.bpmn._20100524.model.TDefinitions;

import com.fing.pis.bizativiti.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.utils.bpmnwriter.FileHandler;

public class BPMNWriterTest {

    @Test
    public void testBPMNWriter() {
        // creamos un metamodelo basico
        MetamodelPackage simplePackage = getMetamodel();
        // convertimos el metamodelo a BPMN
        JAXBElement<TDefinitions> bpmnModel = new BPMNWriter().convert(simplePackage);
        // probamos de escribirlo
        FileHandler.writeBPMN(bpmnModel);
    }

    /** Devuelve un modelo básico (minimo) para probar el converter */
    private MetamodelPackage getMetamodel() {
        MetamodelPackage result = new MetamodelPackage();
        result.addElement(new MetamodelStartEvent("id", "name", "description", 1, 2, 3, 4, "lane"));
        return result;
    }

    /** Test que prueba como crear elementos validos para persistir */
    @Test
    public void testCreateBPMN() {
        TDefinitions bpmnDefinitions = new org.omg.spec.bpmn._20100524.model.ObjectFactory().createTDefinitions();
        JAXBElement<TDefinitions> def = new org.omg.spec.bpmn._20100524.model.ObjectFactory()
                .createDefinitions(bpmnDefinitions);
        FileHandler.writeBPMN(def);
    }

    /** Test que prueba como crear elementos validos para persistir */
    @Test
    public void testCreateBPMN_2() {
        TDefinitions bpmnDefinitions = new org.omg.spec.bpmn._20100524.model.ObjectFactory().createTDefinitions();

        BPMNPlane bpmnPlane = new org.omg.spec.bpmn._20100524.di.ObjectFactory().createBPMNPlane();
        bpmnPlane.setId("plane-id");

        bpmnPlane.getDiagramElement();

        BPMNDiagram bpmnDiagram = new org.omg.spec.bpmn._20100524.di.ObjectFactory().createBPMNDiagram();
        bpmnDiagram.setId("test-id");
        bpmnDiagram.setName("test-name");
        bpmnDiagram.setDocumentation("test of documentation");

        bpmnDefinitions.getBPMNDiagram().add(bpmnDiagram);
        JAXBElement<TDefinitions> def = new org.omg.spec.bpmn._20100524.model.ObjectFactory()
                .createDefinitions(bpmnDefinitions);
        FileHandler.writeBPMN(def);
    }

}