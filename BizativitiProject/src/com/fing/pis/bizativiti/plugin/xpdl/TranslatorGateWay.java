package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.List;

import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.Route;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelEventBasedGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelExclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelInclusiveGateway;
import com.fing.pis.bizativiti.common.metamodel.MetamodelParallelGateway;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

public class TranslatorGateWay extends ATranslator {

    /*
     *             &lt;enumeration value="XOR"/>
     *             &lt;enumeration value="OR"/>
     *             &lt;enumeration value="AND"/>
     *             &lt;enumeration value="Exclusive"/>
     *             &lt;enumeration value="Inclusive"/>
     *             &lt;enumeration value="Parallel"/>
     *             &lt;enumeration value="Complex"/>
     * 
     * 
     * */

    public enum GateWayType {
        XOR, OR, AND, Exclusive, Inclusive, Parallel, Complex
    };

    /*
     *             &lt;enumeration value="Data"/>
     *             &lt;enumeration value="Event"/>
     * 
     * 
     * */
    public enum ExclusiveType {
        Data, Event
    };

    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        List<MetamodelElement> result = new ArrayList<MetamodelElement>();
        Route route = (Route) node;
        Activity activity = (Activity) pathFromRoot.get(pathFromRoot.size() - 2);

        String name = Util.getName(activity);
        String description = Util.getDescription(activity);
        String id = Util.getId(activity);
        double x = Util.getX(activity);
        double y = Util.getY(activity);
        double width = Util.getWidth(activity);
        double height = Util.getHeight(activity);

        MetamodelGateway gateway = null;
        // route.getGatewayType() tiene por definicion el default "Exclusive" para las gateway comunes
        GateWayType gateType = GateWayType.valueOf(route.getGatewayType());
        switch (gateType) {
            case Parallel:
                gateway = new MetamodelParallelGateway(id, name, description, x, y, width, height);
                break;
            case Inclusive:
                gateway = new MetamodelInclusiveGateway(id, name, description, x, y, width, height);
                break;
            case Exclusive:
                // route.getExclusiveType() Tiene por definicion el default "Data" para las gateways comunes
                ExclusiveType exclusiveType = ExclusiveType.valueOf(route.getExclusiveType());
                switch (exclusiveType) {
                    case Event:
                        gateway = new MetamodelEventBasedGateway(id, name, description, x, y, width, height);
                        break;
                    case Data:
                        gateway = new MetamodelExclusiveGateway(id, name, description, x, y, width, height);
                        break;
                    default:
                        throw new RuntimeException("Gateway type no soportado: " + gateType.toString());
                }
                break;

            default:
                throw new RuntimeException("Gateway type no soportado: " + gateType.toString());
        }
        result.add(gateway);

        return result;
    }

}
