package com.fing.pis.bizativiti.plugin.xpdl;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import com.fing.pis.bizativiti.common.IPlugin;
import com.fing.pis.bizativiti.common.metamodel.MetamodelElement;
import com.fing.pis.bizativiti.plugin.xpdl.events.TranslatorEvent;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorImplementation;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskSend;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskManual;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskBusinessRule;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskScript;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskService;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTaskUser;
import com.fing.pis.bizativiti.plugin.xpdl.tasks.TranslatorTask;

public class Facade implements IPlugin {

    // TODO: por ahora se genera un converter sin la intervención del usuario.
    // Hay que cambiar esto para que luego el usuario pueda mediante parametros cambiar la creación
    // @formatter:off
    private Converter converter = new Converter.Builder()
        .add(org.wfmc._2009.xpdl2.PackageType.class, new TranslatorPackageType())
        .add(org.wfmc._2009.xpdl2.ProcessType.class, new TranslatorProcessType())
        .add(org.wfmc._2009.xpdl2.WorkflowProcesses.class, new TranslatorWorkflowProcesses())
        .add(org.wfmc._2009.xpdl2.ProcessHeader.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.RedefinableHeader.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.ActivitySets.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.DataInputOutputs.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.ExtendedAttributes.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Activities.class, new TranslatorActivities())
        .add(org.wfmc._2009.xpdl2.Activity.class, new TranslatorActivity())
        .add(org.wfmc._2009.xpdl2.Description.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Event.class, new TranslatorEvent())
        .add(org.wfmc._2009.xpdl2.Implementation.class, new TranslatorImplementation())
        .add(org.wfmc._2009.xpdl2.Task.class, new TranslatorTask())
        .add(org.wfmc._2009.xpdl2.TaskUser.class, new TranslatorTaskUser())
        .add(org.wfmc._2009.xpdl2.TaskBusinessRule.class, new TranslatorTaskBusinessRule())
        .add(org.wfmc._2009.xpdl2.TaskManual.class, new TranslatorTaskManual())
        // .add(org.wfmc._2009.xpdl2.TaskReceive.class, )
        // .add(org.wfmc._2009.xpdl2.TaskReference.class,)
        .add(org.wfmc._2009.xpdl2.TaskScript.class, new TranslatorTaskScript())
        .add(org.wfmc._2009.xpdl2.TaskSend.class, new TranslatorTaskSend())
        .add(org.wfmc._2009.xpdl2.TaskService.class, new TranslatorTaskService())
        .add(org.wfmc._2009.xpdl2.Performers.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Loop.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Documentation.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.NodeGraphicsInfos.class, DummyTranslator.getInstance())
        .add(org.wfmc._2009.xpdl2.Associations.class, new TranslatorAssociations())
        .add(org.wfmc._2009.xpdl2.Association.class, new TranslatorAssociation())
        .add(org.wfmc._2009.xpdl2.Transitions.class, new TranslatorTransitions())
        .add(org.wfmc._2009.xpdl2.Transition.class, new TranslatorTransition())
        .create();
    // @formatter:on

    @Override
    public String getType() {
        return "xpdl";
    }

    @Override
    public List<MetamodelElement> parse(InputStream stream) {
        org.wfmc._2009.xpdl2.PackageType root = deserializeXML(stream);
        return converter.start(root);
    }

    // TODO: verificar si pueden ocurrir casos en que el reader quede abierto y no se liberen recursos
    private org.wfmc._2009.xpdl2.PackageType deserializeXML(InputStream stream) {
        org.wfmc._2009.xpdl2.PackageType result = null;
        try {
            // Contexto JAXB con la clase que corresponde al root del xml
            JAXBContext xpdlContext = JAXBContext.newInstance(org.wfmc._2009.xpdl2.PackageType.class);
            Unmarshaller unmarshallerXpdl = xpdlContext.createUnmarshaller();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
            JAXBElement<org.wfmc._2009.xpdl2.PackageType> jaxbPackage = unmarshallerXpdl.unmarshal(reader,
                    org.wfmc._2009.xpdl2.PackageType.class);
            // Obrenemos el elemento root del xml 
            result = jaxbPackage.getValue();
            reader.close();
        } catch (Exception e) {
            // relanzar
            throw new RuntimeException(e);
        }
        return result;
    }

}