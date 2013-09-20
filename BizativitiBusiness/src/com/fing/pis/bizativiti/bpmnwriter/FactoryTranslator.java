package com.fing.pis.bizativiti.bpmnwriter;

import java.util.ArrayList;
import java.util.List;

public class FactoryTranslator {

    private static final List<Translator> translators = new ArrayList<>();
    static {
        // registrar translators aqui
        // translators.add(new TranslatorImpl());
        translators.add(new StartEventTranslator());
        translators.add(new EndEventTranslator());
        translators.add(new SequenceTranslator());
        translators.add(new TaskTranslator());
        translators.add(new GatewayTranslator());
    }

    /** Obtener {@link Translator} para el objeto o */
    public Translator getTranslator(Object o) {
        for (Translator t : translators) {
            if (t.canTranslate(o)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Can't translate object " + o);
    }

}