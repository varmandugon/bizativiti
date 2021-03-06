package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.Activity;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorActivity extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {

        Activity activity = (Activity) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        for (Object child : activity.getContent()) {
            result.addAll(f.eval(child, pathFromRoot));
        }

        return result;
    }

}