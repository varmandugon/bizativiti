package com.fing.pis.bizativiti.plugin.xpdl.tasks;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.TaskScript;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.ATranslator;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorTareaScript extends ATranslator {

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {

        TaskScript tareaScript = (TaskScript) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();

        //TODO: Crear Tarea Especifica

        return result;
    }

}
