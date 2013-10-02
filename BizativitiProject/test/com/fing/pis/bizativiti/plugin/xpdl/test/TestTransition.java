package com.fing.pis.bizativiti.plugin.xpdl.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelSequenceFlow;
import com.fing.pis.bizativiti.plugin.xpdl.TranslatorTransition;

public class TestTransition {

    @Test
    public void testTransition() {
        // @formatter:off
        String input = 
        "<Transition Id=\"4c7b8dc5-f51b-40a1-82a2-68326b468898\" From=\"e8706fd1-e19b-4518-81c3-12a49d5bb8c9\" To=\"ca91c5ee-85a2-4734-861d-5f7dbf3b7e66\" Name=\"Si\">" +
        "  <Condition Type=\"CONDITION\">" +
        "    <Expression />\n" +
        "  </Condition>\n" +
        "  <Description />\n" +
        "  <ConnectorGraphicsInfos>\n" +
        "    <ConnectorGraphicsInfo ToolId=\"BizAgi_Process_Modeler\" BorderColor=\"-16777216\">\n" +
        "      <Coordinates XCoordinate=\"692\" YCoordinate=\"372\" />\n" +
        "      <Coordinates XCoordinate=\"692\" YCoordinate=\"486\" />\n" +
        "    </ConnectorGraphicsInfo>\n" +
        "  </ConnectorGraphicsInfos>\n" +
        "  <ExtendedAttributes />\n" +
        "</Transition>";
        // @formatter:on
        org.wfmc._2009.xpdl2.Transition xpdlTransition = (org.wfmc._2009.xpdl2.Transition) Util.parse(input,
                org.wfmc._2009.xpdl2.Transition.class);
        List<MetamodelElement> result = new TranslatorTransition().translate(null, xpdlTransition, null);
        assertEquals(1, result.size());

        MetamodelElement elem = result.get(0);
        assertEquals(MetamodelSequenceFlow.class, elem.getClass());

        MetamodelSequenceFlow sequenceFlow = (MetamodelSequenceFlow) elem;
        assertEquals("4c7b8dc5-f51b-40a1-82a2-68326b468898", sequenceFlow.getId());
    }

}