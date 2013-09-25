package com.fing.pis.bizativiti.core.bpmn;

import com.fing.pis.bizativiti.core.bpmn.Converter.Builder;

public class FactoryConverter {

    private static Converter converter = null;

    public static Converter getInstance() {
        if (converter == null) {
            Builder builder = new Builder();
            // Poner aca los adds al builder.

            converter = builder.create();
        }
        return converter;

    }

}
