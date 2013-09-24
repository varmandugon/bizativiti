package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.List;

public abstract class ATranslator {

    public abstract Object translate(Converter f, Object node, List<Object> pathFromRoot);

}