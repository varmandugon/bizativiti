package com.fing.pis.bizativiti.plugin.xpdl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wfmc._2009.xpdl2.PackageType;

import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.common.metamodel.MetamodelPackage;
import com.fing.pis.bizativiti.plugin.xpdl.Converter.ParserConverter;

/**
 * Translator de {@link org.wfmc._2009.xpdl2.PackageType}
 */
public class TranslatorPackageType extends ATranslator {

    /**
     * Translator de la raiz del XPDL
     * 
     * Llama recursivamente y junta los resultados de cada nodo.<br/>
     * Devuelve una lista con un solo elemento: MetamodelPackage.<br/>
     * El MetamodelPackage contiene todos los elementos procesados.<br/>
     * NOTA: Por ahora solo tomamos en cuenta el nodo WorkflowProcesses
     */
    @Override
    public List<MetamodelElement> translate(ParserConverter f, Object node, List<Object> pathFromRoot) {
        PackageType packageType = (PackageType) node;

        List<MetamodelElement> elements = new ArrayList<MetamodelElement>();
        Object childNode = packageType.getWorkflowProcesses();
        elements.addAll(f.eval(childNode, pathFromRoot));

        String description = packageType.getPackageHeader().getDescription().getValue();
        MetamodelElement result = new MetamodelPackage(packageType.getId(), description, packageType.getName(),
                elements);
        return Arrays.asList(result);
    }

}