package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;

/**
 * Translator de {@link org.wfmc._2009.xpdl2.w}
 */
public class TranslatorWorkflowProcess extends ATranslator {

    /**
     * Llama recursivamente y junta los resultados de cada nodo. NOTA: Por ahora
     * solo tomamos en cuenta el nodo WorkflowProcesses
     */
    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.WorkflowProcesses workflowProcesses = (org.wfmc._2009.xpdl2.WorkflowProcesses) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        // el translator no pude manejar una lista de object, debemos hacer la iteración manualmente
        for (org.wfmc._2009.xpdl2.ProcessType child : workflowProcesses.getWorkflowProcess()) {
            result.addAll(f.eval(child, pathFromRoot));
        }
        return result;
    }

}