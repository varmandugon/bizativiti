package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;

public class TranslatorTransitions extends ATranslator {

    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.Transitions transitions = (org.wfmc._2009.xpdl2.Transitions) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        // el translator no pude manejar una lista de object, debemos hacer la iteración manualmente
        for (org.wfmc._2009.xpdl2.Transition child : transitions.getTransition()) {
            result.addAll(f.eval(child, pathFromRoot));
        }
        return result;
    }

}