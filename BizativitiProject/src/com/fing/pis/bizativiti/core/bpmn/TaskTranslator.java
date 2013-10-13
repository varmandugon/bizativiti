package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TBusinessRuleTask;
import org.omg.spec.bpmn._20100524.model.TDocumentation;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TManualTask;
import org.omg.spec.bpmn._20100524.model.TSendTask;
import org.omg.spec.bpmn._20100524.model.TServiceTask;
import org.omg.spec.bpmn._20100524.model.TTask;
import org.omg.spec.bpmn._20100524.model.TUserTask;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelBusinessTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelManualTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelScriptTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelSendTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelServiceTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelUserTask;
import com.fing.pis.bizativiti.plugin.xpdl.Util;

public class TaskTranslator extends ATranslator {
    //////////////////////////////////////////////
    /// Esto esta mal en el nuevo diseno!!!!!!!!!
    //////////////////////////////////////////////
    @Override
    public JAXBElement<? extends TFlowElement> getFlowElement(Object o, TranslatorState e) {
        MetamodelTask task = (MetamodelTask) o;
        TTask bpmnTask = null;
        JAXBElement<? extends TTask> jaxbtask;
        if (isManualTask(task)) {
            TManualTask t = e.getModelFactory().createTManualTask();
            //TODO: Propiedades especificas de un manual tasks
            bpmnTask = t;
            jaxbtask = e.getModelFactory().createManualTask(t);
        } else if (isUserTask(task)) {
            TUserTask t = e.getModelFactory().createTUserTask();
            //TODO: Propiedades especificas de user tasks
            bpmnTask = t;
            jaxbtask = e.getModelFactory().createUserTask(t);
        } else if (isServiceTask(task)) {
            TServiceTask t = e.getModelFactory().createTServiceTask();
            //TODO: Propiedades especificas de un service tasks
            bpmnTask = t;
            jaxbtask = e.getModelFactory().createServiceTask(t);
        } else if (isBuissnessRuleTask(task)) {
            TBusinessRuleTask t = e.getModelFactory().createTBusinessRuleTask();
            bpmnTask = t;
            jaxbtask = e.getModelFactory().createBusinessRuleTask(t);
        } else if (isSendTask(task)) {
            TSendTask t = e.getModelFactory().createTSendTask();
            bpmnTask = t;
            jaxbtask = e.getModelFactory().createSendTask(t);
        } else {
            bpmnTask = e.getModelFactory().createTTask();
            jaxbtask = e.getModelFactory().createTask(bpmnTask);
        }
        switch (task.getLoop()) {
            case Multi:
                bpmnTask.setLoopCharacteristics(e.getModelFactory().createLoopCharacteristics(
                        e.getModelFactory().createTMultiInstanceLoopCharacteristics()));
                break;
            case Standard:
                bpmnTask.setLoopCharacteristics(e.getModelFactory().createLoopCharacteristics(
                        e.getModelFactory().createTStandardLoopCharacteristics()));
                break;
            default:
                // En bpmn si el loop es none parece que no lleva nada.
                break;

        }
        bpmnTask.setId(task.getId());
        bpmnTask.setName(task.getName());
        if (task.getDescription() != null) {
            TDocumentation documentation = new TDocumentation();
            documentation.getContent().add(Util.getPlainTextFromHTML(task.getDescription()));
            bpmnTask.getDocumentation().add(documentation);
        }

        return jaxbtask;
    }

    private boolean isUserTask(MetamodelElement element) {
        return element instanceof MetamodelUserTask;
    }

    private boolean isManualTask(MetamodelElement element) {
        return element instanceof MetamodelManualTask;
    }

    private boolean isServiceTask(MetamodelElement element) {
        return element instanceof MetamodelServiceTask;
    }

    private boolean isScriptTask(MetamodelElement element) {
        return element instanceof MetamodelScriptTask;
    }

    private boolean isBuissnessRuleTask(MetamodelElement element) {
        return element instanceof MetamodelBusinessTask;
    }

    private boolean isSendTask(MetamodelElement element) {
        return element instanceof MetamodelSendTask;
    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}