package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.Activities;
import org.wfmc._2009.xpdl2.Activity;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorActivities extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        Activities activities = (Activities) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        // el translator no pude manejar una lista de object, debemos hacer la iteración manualmente
        for (Activity child : activities.getActivity()) {
            result.addAll(f.eval(child, pathFromRoot));
        }
        return result;
    }

}