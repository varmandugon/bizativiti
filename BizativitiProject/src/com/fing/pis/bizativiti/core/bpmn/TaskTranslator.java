package com.fing.pis.bizativiti.core.bpmn;

import javax.xml.bind.JAXBElement;

import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.omg.spec.bpmn._20100524.model.TManualTask;
import org.omg.spec.bpmn._20100524.model.TTask;
import org.omg.spec.bpmn._20100524.model.TUserTask;
import org.omg.spec.dd._20100524.di.DiagramElement;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelManualTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelUserTask;

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
        return jaxbtask;
    }

    private boolean isUserTask(MetamodelElement element) {
        return element instanceof MetamodelUserTask;
    }

    private boolean isManualTask(MetamodelElement element) {
        return element instanceof MetamodelManualTask;
    }

    @Override
    public JAXBElement<? extends DiagramElement> getDiagramElement(Object o, TranslatorState e) {
        return Helper.createShape((MetamodelFlowElement) o);
    }

}