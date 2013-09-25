package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.List;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelElement;

public abstract class ATranslator {

    public abstract List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot);

}