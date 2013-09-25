package com.fing.pis.bizativiti.core.bpmn;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    public ATranslator eval(Object node) {
        // vemos si existe un translator para el nodo
        ATranslator trans = translators.get(node.getClass());
        if (trans == null) {
            throw new IllegalArgumentException("No se agregaron translators para nodos del tipo " + node.getClass());
        }
        return trans;
    }

}