package com.fing.pis.bizativiti;

import java.io.InputStream;
import java.util.List;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;

public interface IPlugin {

    String getType();

    List<MetamodelElement> parse(InputStream stream);

}