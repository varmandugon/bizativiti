package com.fing.pis.bizativiti.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wfmc._2009.xpdl2.Activities;
import org.wfmc._2009.xpdl2.Activity;
import org.wfmc._2009.xpdl2.ConnectorGraphicsInfo;
import org.wfmc._2009.xpdl2.Coordinates;
import org.wfmc._2009.xpdl2.Description;
import org.wfmc._2009.xpdl2.Documentation;
import org.wfmc._2009.xpdl2.Event;
import org.wfmc._2009.xpdl2.Implementation;
import org.wfmc._2009.xpdl2.Loop;
import org.wfmc._2009.xpdl2.NodeGraphicsInfo;
import org.wfmc._2009.xpdl2.NodeGraphicsInfos;
import org.wfmc._2009.xpdl2.PackageType;
import org.wfmc._2009.xpdl2.Route;
import org.wfmc._2009.xpdl2.Task;
import org.wfmc._2009.xpdl2.Transition;
import org.wfmc._2009.xpdl2.Transitions;

import com.fing.pis.bizativiti.metamodel.MetamodelConnector;
import com.fing.pis.bizativiti.metamodel.MetamodelCoordinate;
import com.fing.pis.bizativiti.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.metamodel.MetamodelEvent;
import com.fing.pis.bizativiti.metamodel.MetamodelFlowElement;
import com.fing.pis.bizativiti.metamodel.MetamodelGateway;
import com.fing.pis.bizativiti.metamodel.MetamodelInclusiveGateway;
import com.fing.pis.bizativiti.metamodel.MetamodelManualTask;
import com.fing.pis.bizativiti.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.metamodel.MetamodelParallelGateway;
import com.fing.pis.bizativiti.metamodel.MetamodelSequenceFlow;
import com.fing.pis.bizativiti.metamodel.MetamodelStartEvent;
import com.fing.pis.bizativiti.metamodel.MetamodelTask;
import com.fing.pis.bizativiti.metamodel.MetamodelTask.LoopType;
import com.fing.pis.bizativiti.metamodel.MetamodelUserTask;

public class XPDLParser {

    private Map<String, MetamodelElement> metamodelElemens = new HashMap<String, MetamodelElement>();

    public MetamodelPackage convert(PackageType xpdl) {
        MetamodelPackage metamodelPackage = new MetamodelPackage();
        metamodelPackage.setName(xpdl.getPackageHeader().getDescription().getValue());
        List<Object> xpdlWorkflowContent = xpdl.getWorkflowProcesses().getWorkflowProcess().get(1).getContent();
        // TODO: iterar sobre todos los workflowprocess, no solo el primer
        // elemento
        for (Object workflowObject : xpdlWorkflowContent) {
            if (isActivities(workflowObject)) {
                for (Activity activity : ((Activities) workflowObject).getActivity()) {
                    for (Object activityObject : activity.getContent()) {
                        if (isEvent(activityObject)) {
                            MetamodelElement e = createMetamodelEvent(activity, (Event) activityObject);
                            metamodelPackage.addElement(e);
                            metamodelElemens.put(e.getId(), e);
                            break;
                        }
                        if (isImplementation(activityObject)) {
                            Implementation i = (Implementation) activityObject;
                            if (i.getTask() != null) {
                                MetamodelElement e = createMetamodelTask(activity, i.getTask());
                                metamodelPackage.addElement(e);
                                metamodelElemens.put(e.getId(), e);
                                break;
                            }
                        }
                        if (isGateWay(activityObject)) {
                            Route route = (Route) activityObject;
                            MetamodelElement e = createMetamodelGateWay(activity, route);
                            metamodelPackage.addElement(e);
                            metamodelElemens.put(e.getId(), e);
                            break;
                        }
                    }
                }
            }
            if (isTransitions(workflowObject)) {
                Transitions transitions = (Transitions) workflowObject;
                for (Transition transition : transitions.getTransition()) {
                    MetamodelElement e = createMetamodelTransition(transition);
                    metamodelPackage.addElement(e);
                    metamodelElemens.put(e.getId(), e);
                }
            }
        }
        return metamodelPackage;
    }

    private MetamodelTask createMetamodelTask(Activity activity, Task task) {
        MetamodelTask result;
        String id = activity.getId();
        String name = activity.getName();
        String description = null;
        // TODO: documentation por ahora no es usado
        String documentation = null;
        double x = -1;
        double y = -1;
        double width = -1;
        double height = -1;
        String pool = "";
        LoopType loop = LoopType.None;
        // TODO: el lane se encuentra en el contenedor del activity hay que leerlo!!!
        String lane = "";
        for (Object element : activity.getContent()) {
            if (isDescription(element)) {
                description = ((Description) element).getValue();
            } else if (isDocumentation(element)) {
                documentation = ((Documentation) element).getValue();
            } else if (isNodeGraphicsInfo(element)) {
                NodeGraphicsInfo nodeGraphicsInfo = ((NodeGraphicsInfos) element).getNodeGraphicsInfo().get(0);
                width = nodeGraphicsInfo.getWidth();
                height = nodeGraphicsInfo.getHeight();
                x = nodeGraphicsInfo.getCoordinates().getXCoordinate();
                y = nodeGraphicsInfo.getCoordinates().getYCoordinate();
            } else if (isLoop(element)) {
                Loop xpdlLoop = (Loop) element;
                if (xpdlLoop.getLoopType().equals("None")) {
                    loop = LoopType.None;
                } else if (xpdlLoop.getLoopType().equals("Standard")) {
                    loop = LoopType.Standard;
                } else if (xpdlLoop.getLoopType().equals("Multi-Instance")) {
                    loop = LoopType.Multi;
                }
            }
        }
        if (task.getTaskUser() != null) {
            result = new MetamodelUserTask(id, name, description, x, y, width, height, loop, pool, lane);
        } else if (task.getTaskManual() != null) {
            result = new MetamodelManualTask(id, name, description, x, y, width, height, loop, pool, lane);
        } else {
            result = new MetamodelTask(id, name, description, x, y, width, height, loop, pool, lane);
        }
        return result;
    }

    private static boolean isGateWay(Object activityObject) {
        return activityObject instanceof Route;
    }

    private static boolean isTransitions(Object o) {
        return o instanceof Transitions;
    }

    private static boolean isEvent(Object o) {
        return o instanceof Event;
    }

    private static boolean isImplementation(Object o) {
        return o instanceof Implementation;
    }

    private static boolean isActivities(Object o) {
        return o instanceof Activities;
    }

    private MetamodelElement createMetamodelTransition(Transition transition) {
        MetamodelConnector connector;
        String id = transition.getId();
        String description = transition.getDescription().getValue();
        MetamodelFlowElement toElement = null;
        MetamodelFlowElement fromElement = null;

        toElement = (MetamodelFlowElement) metamodelElemens.get(transition.getTo());
        fromElement = (MetamodelFlowElement) metamodelElemens.get(transition.getFrom());

        connector = new MetamodelSequenceFlow(id, description, toElement, fromElement);

        for (ConnectorGraphicsInfo info : transition.getConnectorGraphicsInfos().getConnectorGraphicsInfo()) {
            for (Coordinates coordinate : info.getCoordinates()) {
                connector.addCoordinate(new MetamodelCoordinate(coordinate.getXCoordinate(), coordinate
                        .getYCoordinate()));
            }
        }

        return connector;

    }

    private MetamodelElement createMetamodelGateWay(Activity activity, Route route) {
        MetamodelGateway result;
        String id = activity.getId();
        String name = activity.getName();
        String description = null;
        String documentation = null;
        double width = -1;
        double height = -1;
        double x = -1, y = -1;
        for (Object element : activity.getContent()) {
            if (isDescription(element)) {
                description = ((Description) element).getValue();
            } else if (isDocumentation(element)) {
                documentation = ((Documentation) element).getValue();
            } else if (isNodeGraphicsInfo(element)) {
                NodeGraphicsInfo nodeGraphicsInfo = ((NodeGraphicsInfos) element).getNodeGraphicsInfo().get(0);
                width = nodeGraphicsInfo.getWidth();
                height = nodeGraphicsInfo.getHeight();
                x = nodeGraphicsInfo.getCoordinates().getXCoordinate();
                y = nodeGraphicsInfo.getCoordinates().getYCoordinate();
            }
        }
        System.out.print(route.getGatewayType());
        if (route.getGatewayType() != null) {
            if (route.getGatewayType().equals("Parallel")) {
                result = new MetamodelParallelGateway(id, name, description, x, y, width, height);
            } else if (route.getGatewayType().equals("Inclusive")) {
                result = new MetamodelInclusiveGateway(id, name, description, x, y, width, height);
            } else {
                throw new RuntimeException("unknow gate way " + route);
            }
        } else {
            result = new MetamodelGateway(id, name, description, x, y, width, height);
        }

        return result;

    }

    private static MetamodelEvent createMetamodelEvent(Activity activity, Event event) {
        MetamodelEvent result;
        String id = activity.getId();
        String name = activity.getName();
        String description = null;
        // TODO: documentation por ahora no es usado
        String documentation = null;
        double x = -1;
        double y = -1;
        double width = -1;
        double height = -1;
        // TODO: el lane se encuentra en el contenedor del activity hay que leerlo!!!
        String lane = "";
        for (Object element : activity.getContent()) {
            if (isDescription(element)) {
                description = ((Description) element).getValue();
            } else if (isDocumentation(element)) {
                documentation = ((Documentation) element).getValue();
            } else if (isNodeGraphicsInfo(element)) {
                NodeGraphicsInfo nodeGraphicsInfo = ((NodeGraphicsInfos) element).getNodeGraphicsInfo().get(0);
                width = nodeGraphicsInfo.getWidth();
                height = nodeGraphicsInfo.getHeight();
                x = nodeGraphicsInfo.getCoordinates().getXCoordinate();
                y = nodeGraphicsInfo.getCoordinates().getYCoordinate();
            }
        }
        if (event.getStartEvent() != null) {
            result = new MetamodelStartEvent(id, name, description, x, y, width, height, lane);
        } else if (event.getEndEvent() != null) {
            result = new MetamodelStartEvent(id, name, description, x, y, width, height, lane);
        } else {
            throw new RuntimeException("unknow event " + event);
        }
        return result;
    }

    private static boolean isDescription(Object element) {
        return element instanceof Description;
    }

    private static boolean isDocumentation(Object element) {
        return element instanceof Documentation;
    }

    private static boolean isNodeGraphicsInfo(Object element) {
        return element instanceof NodeGraphicsInfos;
    }

    private static boolean isLoop(Object element) {
        return element instanceof Loop;
    }

}
