package com.fing.pis.bizativiti.plugin.xpdl;

import java.io.InputStream;
import java.util.List;

import com.fing.pis.bizativiti.IPlugin;
import com.fing.pis.bizativiti.metamodel.MetamodelElement;

public class Facade implements IPlugin {

    @Override
    public String getType() {
        return "xpdl";
    }

    @Override
    public List<MetamodelElement> parse(InputStream stream) {
        // TODO Auto-generated method stub
        return null;
    }

}