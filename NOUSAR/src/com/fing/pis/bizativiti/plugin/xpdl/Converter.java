package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fing.pis.bizativiti.metamodel.MetamodelElement;

public class Converter {

    private Map<Class<?>, ATranslator> translators;

    public static class Builder {
        private Map<Class<?>, ATranslator> translators = new HashMap<Class<?>, ATranslator>();

        public Builder add(Class<?> node, ATranslator translator) {
            translators.put(node, translator);
            return this;
        }

        public Converter create() {
            return new Converter(this);
        }

    }

    private Converter(Builder builder) {
        translators = Collections.unmodifiableMap(builder.translators);
    }

    public List<MetamodelElement> eval(Object node, List<Object> pathFromRootWithoutNode) {
        // vemos si existe un translator para el nodo
        ATranslator trans = translators.get(node.getClass());
        if (trans == null) {
            throw new IllegalArgumentException("No se agregaron translators para nodos del tipo " + node.getClass());
        }
        // construimos el camino hacia el elemento (incluyendolo)
        List<Object> pathFromRoot = new ArrayList<Object>(pathFromRootWithoutNode);
        pathFromRoot.add(node);
        return trans.translate(this, node, Collections.unmodifiableList(pathFromRoot));
    }

}