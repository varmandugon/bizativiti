package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;

/**
 * Translator de {@link org.wfmc._2009.xpdl2.PackageType}
 */
public class TranslatorPackageType extends ATranslator {

    /**
     * Translator de la raiz del XPDL
     * 
     * Llama recursivamente y junta los resultados de cada nodo. NOTA: Por ahora
     * solo tomamos en cuenta el nodo WorkflowProcesses
     */
    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.PackageType packageType = (org.wfmc._2009.xpdl2.PackageType) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        Object childNode = packageType.getWorkflowProcesses();
        result.addAll(f.eval(childNode, pathFromRoot));
        return result;
    }

}