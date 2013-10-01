package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;

public class TranslatorAssociations extends ATranslator {

    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        org.wfmc._2009.xpdl2.Associations associations = (org.wfmc._2009.xpdl2.Associations) node;
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        // el translator no pude manejar una lista de object, debemos hacer la iteración manualmente
        for (Object child : associations.getAssociationAndAny()) {
            // child puede ser de los siguientes tipos
            // * org.w3c.dom.Element
            // * java.lang.Object
            // * org.wfmc._2009.xpdl2.Association
            result.addAll(f.eval(child, pathFromRoot));
        }
        return result;
    }

}