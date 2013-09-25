package com.fing.pis.bizativiti.plugin.xpdl;

/**
 * Clase con métodos auxiliares utilizados por los translators
 */
public class Util {

    private Util() {}

    public static String getDescription(org.wfmc._2009.xpdl2.Activity activity) {
        for (Object child : activity.getContent()) {
            if (child instanceof org.wfmc._2009.xpdl2.Description) {
                return ((org.wfmc._2009.xpdl2.Description) child).getValue();
            }
        }
        throw new RuntimeException("Description not found in activity");
    }

    public static String getId(org.wfmc._2009.xpdl2.Activity activity) {
        return activity.getId();
    }

    public static String getName(org.wfmc._2009.xpdl2.Activity activity) {
        return activity.getName();
    }

}