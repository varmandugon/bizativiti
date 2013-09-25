package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.core.common.metamodel.MetamodelElement;

/**
 * Translator dummy.
 * 
 * Detiene el procesamiento recursivo, devuelve una lista vacia de elementos
 * Para utilizar cuando no se desea procesar un elemento
 * 
 * SINGLETON
 */
public class DummyTranslator extends ATranslator {

    private static DummyTranslator instance;

    private DummyTranslator() {}

    public static DummyTranslator getInstance() {
        if (instance == null) {
            instance = new DummyTranslator();
        }
        return instance;
    }

    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        return new ArrayList<MetamodelElement>();
    }

}