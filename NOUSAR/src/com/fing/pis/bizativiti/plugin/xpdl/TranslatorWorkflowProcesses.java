package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;

/**
 * Translator de {@link org.wfmc._2009.xpdl2.WorkflowProcesses}
 */
public class TranslatorWorkflowProcesses extends ATranslator {

    /**
     * Llama recursivamente y junta los resultados de cada nodo. NOTA: Por ahora
     * solo tomamos en cuenta el nodo WorkflowProcesses
     */
    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.WorkflowProcesses workflowProcesses = (org.wfmc._2009.xpdl2.WorkflowProcesses) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        for (org.wfmc._2009.xpdl2.ProcessType child : workflowProcesses.getWorkflowProcess()) {
            // el translator no pude manejar una lista de object, debemos hacer la iteración manualmente
            List<Object> newPath = new ArrayList<Object>(pathFromRoot);
            newPath.add(child);
            for (Object content : child.getContent()) {
                result.addAll(f.eval(content, newPath));
            }
        }
        return result;
    }

}