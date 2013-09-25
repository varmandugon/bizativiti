package com.fing.pis.bizativiti.common;

import java.io.InputStream;
import java.util.List;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;

public interface IPlugin {

    String getType();

    List<MetamodelElement> parse(InputStream stream);

}