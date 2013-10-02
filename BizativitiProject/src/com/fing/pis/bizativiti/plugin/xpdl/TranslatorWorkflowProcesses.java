package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

/**
 * Translator de {@link org.wfmc._2009.xpdl2.WorkflowProcesses}
 */
public class TranslatorWorkflowProcesses extends ATranslator {

    /**
     * Llama recursivamente y junta los resultados de cada nodo.
     */
    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.WorkflowProcesses workflowProcesses = (org.wfmc._2009.xpdl2.WorkflowProcesses) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        for (org.wfmc._2009.xpdl2.ProcessType child : workflowProcesses.getWorkflowProcess()) {
            // el translator no pude manejar una lista de objetos, debemos hacer la iteración manualmente
            result.addAll(f.eval(child, pathFromRoot));
        }
        return result;
    }

}