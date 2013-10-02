package com.fing.pis.bizativiti.plugin.xpdl.tasks;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.Task;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.ATranslator;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorTarea extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {

        Task tarea = (Task) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();

        // FIXME: y si es tarea simple?
        result.addAll(f.eval(tarea, pathFromRoot));

        return result;
    }

}
