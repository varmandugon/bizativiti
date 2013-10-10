package com.fing.pis.bizativiti.core.bpmn;

import com.fing.pis.bizativiti.common.metamodel.MetamodelEndEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelManualTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelMessageStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelSequenceFlow;
import com.fing.pis.bizativiti.common.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.common.metamodel.MetamodelTask;
import com.fing.pis.bizativiti.common.metamodel.MetamodelUserTask;
import com.fing.pis.bizativiti.core.bpmn.Converter.Builder;

public class FactoryConverter {

    private static Converter converter = null;

    public static Converter getInstance() {

        if (converter == null) {
            Builder builder = new Builder();
            // Poner aca los adds al builder.
            builder.add(MetamodelEndEvent.class, new EndEventTranslator());
            builder.add(MetamodelStartEvent.class, new TimerStartEventTranslator());
            builder.add(MetamodelSequenceFlow.class, new SequenceTranslator());
            builder.add(MetamodelTask.class, new TaskTranslator());
            builder.add(MetamodelStartEvent.class, new StartEventTranslator());
            builder.add(MetamodelMessageStartEvent.class, new MessageStartTranslator());
            builder.add(MetamodelGateway.class, new GatewayTranslator());
            builder.add(MetamodelManualTask.class, new TaskTranslator());
            builder.add(MetamodelUserTask.class, new TaskTranslator());

            converter = builder.create();
        }
        return converter;

    }

}
