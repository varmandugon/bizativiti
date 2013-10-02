package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public abstract class ATranslator {

    public abstract List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot);

}