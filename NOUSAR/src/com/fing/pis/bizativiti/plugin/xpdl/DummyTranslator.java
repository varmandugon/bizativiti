package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;

/**
 * Translator dummy.
 * 
 * Detiene el procesamiento recursivo, devuelve una lista vacia de elementos
 * Para utilizar cuando no se desea procesar un elemento
 * 
 */
public class DummyTranslator extends ATranslator {

    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        return new ArrayList<MetamodelElement>();
    }

}