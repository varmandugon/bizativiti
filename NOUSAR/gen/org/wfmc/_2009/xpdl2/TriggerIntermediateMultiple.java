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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerResultMessage" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerTimer" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}ResultError" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerEscalation" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerResultCompensation" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerConditional" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerResultLink" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerResultCancel" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2009/XPDL2.2}TriggerResultSignal" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
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
    "triggerResultMessage",
    "triggerTimer",
    "resultError",
    "triggerEscalation",
    "triggerResultCompensation",
    "triggerConditional",
    "triggerResultLink",
    "triggerResultCancel",
    "triggerResultSignal",
    "any"
})
@XmlRootElement(name = "TriggerIntermediateMultiple")
public class TriggerIntermediateMultiple {

    @XmlElement(name = "TriggerResultMessage")
    protected TriggerResultMessage triggerResultMessage;
    @XmlElement(name = "TriggerTimer")
    protected TriggerTimer triggerTimer;
    @XmlElement(name = "ResultError")
    protected ResultError resultError;
    @XmlElement(name = "TriggerEscalation")
    protected TriggerEscalation triggerEscalation;
    @XmlElement(name = "TriggerResultCompensation")
    protected TriggerResultCompensation triggerResultCompensation;
    @XmlElement(name = "TriggerConditional")
    protected TriggerConditional triggerConditional;
    @XmlElement(name = "TriggerResultLink")
    protected TriggerResultLink triggerResultLink;
    @XmlElement(name = "TriggerResultCancel")
    protected java.lang.Object triggerResultCancel;
    @XmlElement(name = "TriggerResultSignal")
    protected TriggerResultSignal triggerResultSignal;
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the triggerResultMessage property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerResultMessage }
     *     
     */
    public TriggerResultMessage getTriggerResultMessage() {
        return triggerResultMessage;
    }

    /**
     * Sets the value of the triggerResultMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerResultMessage }
     *     
     */
    public void setTriggerResultMessage(TriggerResultMessage value) {
        this.triggerResultMessage = value;
    }

    /**
     * Gets the value of the triggerTimer property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerTimer }
     *     
     */
    public TriggerTimer getTriggerTimer() {
        return triggerTimer;
    }

    /**
     * Sets the value of the triggerTimer property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerTimer }
     *     
     */
    public void setTriggerTimer(TriggerTimer value) {
        this.triggerTimer = value;
    }

    /**
     * Gets the value of the resultError property.
     * 
     * @return
     *     possible object is
     *     {@link ResultError }
     *     
     */
    public ResultError getResultError() {
        return resultError;
    }

    /**
     * Sets the value of the resultError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultError }
     *     
     */
    public void setResultError(ResultError value) {
        this.resultError = value;
    }

    /**
     * Gets the value of the triggerEscalation property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerEscalation }
     *     
     */
    public TriggerEscalation getTriggerEscalation() {
        return triggerEscalation;
    }

    /**
     * Sets the value of the triggerEscalation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerEscalation }
     *     
     */
    public void setTriggerEscalation(TriggerEscalation value) {
        this.triggerEscalation = value;
    }

    /**
     * Gets the value of the triggerResultCompensation property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerResultCompensation }
     *     
     */
    public TriggerResultCompensation getTriggerResultCompensation() {
        return triggerResultCompensation;
    }

    /**
     * Sets the value of the triggerResultCompensation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerResultCompensation }
     *     
     */
    public void setTriggerResultCompensation(TriggerResultCompensation value) {
        this.triggerResultCompensation = value;
    }

    /**
     * Gets the value of the triggerConditional property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerConditional }
     *     
     */
    public TriggerConditional getTriggerConditional() {
        return triggerConditional;
    }

    /**
     * Sets the value of the triggerConditional property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerConditional }
     *     
     */
    public void setTriggerConditional(TriggerConditional value) {
        this.triggerConditional = value;
    }

    /**
     * Gets the value of the triggerResultLink property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerResultLink }
     *     
     */
    public TriggerResultLink getTriggerResultLink() {
        return triggerResultLink;
    }

    /**
     * Sets the value of the triggerResultLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerResultLink }
     *     
     */
    public void setTriggerResultLink(TriggerResultLink value) {
        this.triggerResultLink = value;
    }

    /**
     * Gets the value of the triggerResultCancel property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Object }
     *     
     */
    public java.lang.Object getTriggerResultCancel() {
        return triggerResultCancel;
    }

    /**
     * Sets the value of the triggerResultCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Object }
     *     
     */
    public void setTriggerResultCancel(java.lang.Object value) {
        this.triggerResultCancel = value;
    }

    /**
     * Gets the value of the triggerResultSignal property.
     * 
     * @return
     *     possible object is
     *     {@link TriggerResultSignal }
     *     
     */
    public TriggerResultSignal getTriggerResultSignal() {
        return triggerResultSignal;
    }

    /**
     * Sets the value of the triggerResultSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerResultSignal }
     *     
     */
    public void setTriggerResultSignal(TriggerResultSignal value) {
        this.triggerResultSignal = value;
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
