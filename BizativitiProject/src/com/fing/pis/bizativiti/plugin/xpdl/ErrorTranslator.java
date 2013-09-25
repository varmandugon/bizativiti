package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.List;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;

/**
 * Translator para lanzar excepciones.
 * 
 * Detiene el procesamiento recursivo y lanza una excepción.
 * 
 */
public class ErrorTranslator extends ATranslator {

    private String message;

    public ErrorTranslator(String message) {
        this.message = message;
    }

    @Override
    public List<MetamodelElement> translate(Converter f, Object node, List<Object> pathFromRoot) {
        throw new RuntimeException(message);
    }

}