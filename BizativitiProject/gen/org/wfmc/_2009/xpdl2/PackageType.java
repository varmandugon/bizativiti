//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.02 at 08:19:07 PM UYT 
//


package org.wfmc._2009.xpdl2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for PackageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PackageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}PackageHeader"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}RedefinableHeader" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}ConformanceClass" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Script" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}ExternalPackages" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TypeDeclarations" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Participants" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Applications" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}DataFields" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}PartnerLinkTypes" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Pages" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}GlobalActivities" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}DataStores" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Pools" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}MessageFlows" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Associations" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Artifacts" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}WorkflowProcesses" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}ExtendedAttributes" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.wfmc.org/2009/XPDL2.2}Id" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Language" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="QueryLanguage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageType", propOrder = {
    "packageHeader",
    "redefinableHeader",
    "conformanceClass",
    "script",
    "externalPackages",
    "typeDeclarations",
    "participants",
    "applications",
    "dataFields",
    "partnerLinkTypes",
    "pages",
    "globalActivities",
    "dataStores",
    "pools",
    "messageFlows",
    "associations",
    "artifacts",
    "workflowProcesses",
    "extendedAttributes",
    "any"
})
public class PackageType {

    @XmlElement(name = "PackageHeader", required = true)
    protected PackageHeader packageHeader;
    @XmlElement(name = "RedefinableHeader")
    protected RedefinableHeader redefinableHeader;
    @XmlElement(name = "ConformanceClass")
    protected ConformanceClass conformanceClass;
    @XmlElement(name = "Script")
    protected Script script;
    @XmlElement(name = "ExternalPackages")
    protected ExternalPackages externalPackages;
    @XmlElement(name = "TypeDeclarations")
    protected TypeDeclarations typeDeclarations;
    @XmlElement(name = "Participants")
    protected Participants participants;
    @XmlElement(name = "Applications")
    protected Applications applications;
    @XmlElement(name = "DataFields")
    protected DataFields dataFields;
    @XmlElement(name = "PartnerLinkTypes")
    protected PartnerLinkTypes partnerLinkTypes;
    @XmlElement(name = "Pages")
    protected Pages pages;
    @XmlElement(name = "GlobalActivities")
    protected GlobalActivities globalActivities;
    @XmlElement(name = "DataStores")
    protected DataStores dataStores;
    @XmlElement(name = "Pools")
    protected Pools pools;
    @XmlElement(name = "MessageFlows")
    protected MessageFlows messageFlows;
    @XmlElement(name = "Associations")
    protected Associations associations;
    @XmlElement(name = "Artifacts")
    protected Artifacts artifacts;
    @XmlElement(name = "WorkflowProcesses")
    protected WorkflowProcesses workflowProcesses;
    @XmlElement(name = "ExtendedAttributes")
    protected ExtendedAttributes extendedAttributes;
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> any;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Language")
    protected String language;
    @XmlAttribute(name = "QueryLanguage")
    protected String queryLanguage;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the packageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link PackageHeader }
     *     
     */
    public PackageHeader getPackageHeader() {
        return packageHeader;
    }

    /**
     * Sets the value of the packageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageHeader }
     *     
     */
    public void setPackageHeader(PackageHeader value) {
        this.packageHeader = value;
    }

    /**
     * Gets the value of the redefinableHeader property.
     * 
     * @return
     *     possible object is
     *     {@link RedefinableHeader }
     *     
     */
    public RedefinableHeader getRedefinableHeader() {
        return redefinableHeader;
    }

    /**
     * Sets the value of the redefinableHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link RedefinableHeader }
     *     
     */
    public void setRedefinableHeader(RedefinableHeader value) {
        this.redefinableHeader = value;
    }

    /**
     * Gets the value of the conformanceClass property.
     * 
     * @return
     *     possible object is
     *     {@link ConformanceClass }
     *     
     */
    public ConformanceClass getConformanceClass() {
        return conformanceClass;
    }

    /**
     * Sets the value of the conformanceClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConformanceClass }
     *     
     */
    public void setConformanceClass(ConformanceClass value) {
        this.conformanceClass = value;
    }

    /**
     * Gets the value of the script property.
     * 
     * @return
     *     possible object is
     *     {@link Script }
     *     
     */
    public Script getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     * @param value
     *     allowed object is
     *     {@link Script }
     *     
     */
    public void setScript(Script value) {
        this.script = value;
    }

    /**
     * Gets the value of the externalPackages property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalPackages }
     *     
     */
    public ExternalPackages getExternalPackages() {
        return externalPackages;
    }

    /**
     * Sets the value of the externalPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalPackages }
     *     
     */
    public void setExternalPackages(ExternalPackages value) {
        this.externalPackages = value;
    }

    /**
     * Gets the value of the typeDeclarations property.
     * 
     * @return
     *     possible object is
     *     {@link TypeDeclarations }
     *     
     */
    public TypeDeclarations getTypeDeclarations() {
        return typeDeclarations;
    }

    /**
     * Sets the value of the typeDeclarations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeDeclarations }
     *     
     */
    public void setTypeDeclarations(TypeDeclarations value) {
        this.typeDeclarations = value;
    }

    /**
     * Gets the value of the participants property.
     * 
     * @return
     *     possible object is
     *     {@link Participants }
     *     
     */
    public Participants getParticipants() {
        return participants;
    }

    /**
     * Sets the value of the participants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Participants }
     *     
     */
    public void setParticipants(Participants value) {
        this.participants = value;
    }

    /**
     * Gets the value of the applications property.
     * 
     * @return
     *     possible object is
     *     {@link Applications }
     *     
     */
    public Applications getApplications() {
        return applications;
    }

    /**
     * Sets the value of the applications property.
     * 
     * @param value
     *     allowed object is
     *     {@link Applications }
     *     
     */
    public void setApplications(Applications value) {
        this.applications = value;
    }

    /**
     * Gets the value of the dataFields property.
     * 
     * @return
     *     possible object is
     *     {@link DataFields }
     *     
     */
    public DataFields getDataFields() {
        return dataFields;
    }

    /**
     * Sets the value of the dataFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataFields }
     *     
     */
    public void setDataFields(DataFields value) {
        this.dataFields = value;
    }

    /**
     * Gets the value of the partnerLinkTypes property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerLinkTypes }
     *     
     */
    public PartnerLinkTypes getPartnerLinkTypes() {
        return partnerLinkTypes;
    }

    /**
     * Sets the value of the partnerLinkTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerLinkTypes }
     *     
     */
    public void setPartnerLinkTypes(PartnerLinkTypes value) {
        this.partnerLinkTypes = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link Pages }
     *     
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pages }
     *     
     */
    public void setPages(Pages value) {
        this.pages = value;
    }

    /**
     * Gets the value of the globalActivities property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalActivities }
     *     
     */
    public GlobalActivities getGlobalActivities() {
        return globalActivities;
    }

    /**
     * Sets the value of the globalActivities property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalActivities }
     *     
     */
    public void setGlobalActivities(GlobalActivities value) {
        this.globalActivities = value;
    }

    /**
     * Gets the value of the dataStores property.
     * 
     * @return
     *     possible object is
     *     {@link DataStores }
     *     
     */
    public DataStores getDataStores() {
        return dataStores;
    }

    /**
     * Sets the value of the dataStores property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataStores }
     *     
     */
    public void setDataStores(DataStores value) {
        this.dataStores = value;
    }

    /**
     * Gets the value of the pools property.
     * 
     * @return
     *     possible object is
     *     {@link Pools }
     *     
     */
    public Pools getPools() {
        return pools;
    }

    /**
     * Sets the value of the pools property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pools }
     *     
     */
    public void setPools(Pools value) {
        this.pools = value;
    }

    /**
     * Gets the value of the messageFlows property.
     * 
     * @return
     *     possible object is
     *     {@link MessageFlows }
     *     
     */
    public MessageFlows getMessageFlows() {
        return messageFlows;
    }

    /**
     * Sets the value of the messageFlows property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFlows }
     *     
     */
    public void setMessageFlows(MessageFlows value) {
        this.messageFlows = value;
    }

    /**
     * Gets the value of the associations property.
     * 
     * @return
     *     possible object is
     *     {@link Associations }
     *     
     */
    public Associations getAssociations() {
        return associations;
    }

    /**
     * Sets the value of the associations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Associations }
     *     
     */
    public void setAssociations(Associations value) {
        this.associations = value;
    }

    /**
     * Gets the value of the artifacts property.
     * 
     * @return
     *     possible object is
     *     {@link Artifacts }
     *     
     */
    public Artifacts getArtifacts() {
        return artifacts;
    }

    /**
     * Sets the value of the artifacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Artifacts }
     *     
     */
    public void setArtifacts(Artifacts value) {
        this.artifacts = value;
    }

    /**
     * Gets the value of the workflowProcesses property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowProcesses }
     *     
     */
    public WorkflowProcesses getWorkflowProcesses() {
        return workflowProcesses;
    }

    /**
     * Sets the value of the workflowProcesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowProcesses }
     *     
     */
    public void setWorkflowProcesses(WorkflowProcesses value) {
        this.workflowProcesses = value;
    }

    /**
     * Gets the value of the extendedAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedAttributes }
     *     
     */
    public ExtendedAttributes getExtendedAttributes() {
        return extendedAttributes;
    }

    /**
     * Sets the value of the extendedAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedAttributes }
     *     
     */
    public void setExtendedAttributes(ExtendedAttributes value) {
        this.extendedAttributes = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link java.lang.Object }
     * 
     * 
     */
    public List<java.lang.Object> getAny() {
        if (any == null) {
            any = new ArrayList<java.lang.Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the queryLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryLanguage() {
        return queryLanguage;
    }

    /**
     * Sets the value of the queryLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryLanguage(String value) {
        this.queryLanguage = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
