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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Activities" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}DataObjects" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}DataStoreReferences" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Transitions" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}DataAssociations" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Object" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Associations" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}Artifacts" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.wfmc.org/2009/XPDL2.2}Id" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AdHoc" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="AdHocOrdering" default="Parallel">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Sequential"/>
 *             &lt;enumeration value="Parallel"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="AdHocCompletionCondition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DefaultStartActivityId" type="{http://www.wfmc.org/2009/XPDL2.2}IdRef" />
 *       &lt;attribute name="TriggeredByEvent" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "activities",
    "dataObjects",
    "dataStoreReferences",
    "transitions",
    "dataAssociations",
    "object",
    "associations",
    "artifacts",
    "any"
})
@XmlRootElement(name = "ActivitySet")
public class ActivitySet {

    @XmlElement(name = "Activities")
    protected Activities activities;
    @XmlElement(name = "DataObjects")
    protected DataObjects dataObjects;
    @XmlElement(name = "DataStoreReferences")
    protected DataStoreReferences dataStoreReferences;
    @XmlElement(name = "Transitions")
    protected Transitions transitions;
    @XmlElement(name = "DataAssociations")
    protected DataAssociations dataAssociations;
    @XmlElement(name = "Object")
    protected org.wfmc._2009.xpdl2.Object object;
    @XmlElement(name = "Associations")
    protected Associations associations;
    @XmlElement(name = "Artifacts")
    protected Artifacts artifacts;
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> any;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "AdHoc")
    protected Boolean adHoc;
    @XmlAttribute(name = "AdHocOrdering")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String adHocOrdering;
    @XmlAttribute(name = "AdHocCompletionCondition")
    protected String adHocCompletionCondition;
    @XmlAttribute(name = "DefaultStartActivityId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String defaultStartActivityId;
    @XmlAttribute(name = "TriggeredByEvent")
    protected Boolean triggeredByEvent;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the activities property.
     * 
     * @return
     *     possible object is
     *     {@link Activities }
     *     
     */
    public Activities getActivities() {
        return activities;
    }

    /**
     * Sets the value of the activities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Activities }
     *     
     */
    public void setActivities(Activities value) {
        this.activities = value;
    }

    /**
     * Gets the value of the dataObjects property.
     * 
     * @return
     *     possible object is
     *     {@link DataObjects }
     *     
     */
    public DataObjects getDataObjects() {
        return dataObjects;
    }

    /**
     * Sets the value of the dataObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataObjects }
     *     
     */
    public void setDataObjects(DataObjects value) {
        this.dataObjects = value;
    }

    /**
     * Gets the value of the dataStoreReferences property.
     * 
     * @return
     *     possible object is
     *     {@link DataStoreReferences }
     *     
     */
    public DataStoreReferences getDataStoreReferences() {
        return dataStoreReferences;
    }

    /**
     * Sets the value of the dataStoreReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataStoreReferences }
     *     
     */
    public void setDataStoreReferences(DataStoreReferences value) {
        this.dataStoreReferences = value;
    }

    /**
     * Gets the value of the transitions property.
     * 
     * @return
     *     possible object is
     *     {@link Transitions }
     *     
     */
    public Transitions getTransitions() {
        return transitions;
    }

    /**
     * Sets the value of the transitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transitions }
     *     
     */
    public void setTransitions(Transitions value) {
        this.transitions = value;
    }

    /**
     * Gets the value of the dataAssociations property.
     * 
     * @return
     *     possible object is
     *     {@link DataAssociations }
     *     
     */
    public DataAssociations getDataAssociations() {
        return dataAssociations;
    }

    /**
     * Sets the value of the dataAssociations property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataAssociations }
     *     
     */
    public void setDataAssociations(DataAssociations value) {
        this.dataAssociations = value;
    }

    /**
     * Gets the value of the object property.
     * 
     * @return
     *     possible object is
     *     {@link org.wfmc._2009.xpdl2.Object }
     *     
     */
    public org.wfmc._2009.xpdl2.Object getObject() {
        return object;
    }

    /**
     * Sets the value of the object property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.wfmc._2009.xpdl2.Object }
     *     
     */
    public void setObject(org.wfmc._2009.xpdl2.Object value) {
        this.object = value;
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
     * Gets the value of the adHoc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAdHoc() {
        if (adHoc == null) {
            return false;
        } else {
            return adHoc;
        }
    }

    /**
     * Sets the value of the adHoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdHoc(Boolean value) {
        this.adHoc = value;
    }

    /**
     * Gets the value of the adHocOrdering property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdHocOrdering() {
        if (adHocOrdering == null) {
            return "Parallel";
        } else {
            return adHocOrdering;
        }
    }

    /**
     * Sets the value of the adHocOrdering property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdHocOrdering(String value) {
        this.adHocOrdering = value;
    }

    /**
     * Gets the value of the adHocCompletionCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdHocCompletionCondition() {
        return adHocCompletionCondition;
    }

    /**
     * Sets the value of the adHocCompletionCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdHocCompletionCondition(String value) {
        this.adHocCompletionCondition = value;
    }

    /**
     * Gets the value of the defaultStartActivityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultStartActivityId() {
        return defaultStartActivityId;
    }

    /**
     * Sets the value of the defaultStartActivityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultStartActivityId(String value) {
        this.defaultStartActivityId = value;
    }

    /**
     * Gets the value of the triggeredByEvent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTriggeredByEvent() {
        if (triggeredByEvent == null) {
            return false;
        } else {
            return triggeredByEvent;
        }
    }

    /**
     * Sets the value of the triggeredByEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTriggeredByEvent(Boolean value) {
        this.triggeredByEvent = value;
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
