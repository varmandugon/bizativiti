package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelElement;

/**
 * Translator de {@link org.wfmc._2009.xpdl2.ProcessType}
 */
public class TranslatorProcessType extends ATranslator {

    /**
     * Llama recursivamente y junta los resultados de cada nodo.
     */
    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.ProcessType processType = (org.wfmc._2009.xpdl2.ProcessType) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        for (Object child : processType.getContent()) {
            result.addAll(f.eval(child, pathFromRoot));
        }
        return result;
    }

}