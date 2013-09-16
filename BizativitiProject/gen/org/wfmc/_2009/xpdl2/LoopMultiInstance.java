//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.02 at 08:19:07 PM UYT 
//


package org.wfmc._2009.xpdl2;

import java.math.BigInteger;
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
 *         &lt;element name="MI_Condition" type="{http://www.wfmc.org/2009/XPDL2.2}ExpressionType" minOccurs="0"/>
 *         &lt;element name="ComplexMI_FlowCondition" type="{http://www.wfmc.org/2009/XPDL2.2}ExpressionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MI_Condition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LoopCounter" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="MI_Ordering" default="Parallel">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Sequential"/>
 *             &lt;enumeration value="Parallel"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="MI_FlowCondition" default="All">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="None"/>
 *             &lt;enumeration value="One"/>
 *             &lt;enumeration value="All"/>
 *             &lt;enumeration value="Complex"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ComplexMI_FlowCondition" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "miCondition",
    "complexMIFlowCondition",
    "any"
})
@XmlRootElement(name = "LoopMultiInstance")
public class LoopMultiInstance {

    @XmlElement(name = "MI_Condition")
    protected ExpressionType miCondition;
    @XmlElement(name = "ComplexMI_FlowCondition")
    protected ExpressionType complexMIFlowCondition;
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> any;
    @XmlAttribute(name = "MI_Condition")
    protected String miConditionAttr;
    @XmlAttribute(name = "LoopCounter")
    protected BigInteger loopCounter;
    @XmlAttribute(name = "MI_Ordering")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String miOrdering;
    @XmlAttribute(name = "MI_FlowCondition")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String miFlowCondition;
    @XmlAttribute(name = "ComplexMI_FlowCondition")
    protected String complexMIFlowConditionAttr;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the miCondition property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getMICondition() {
        return miCondition;
    }

    /**
     * Sets the value of the miCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setMICondition(ExpressionType value) {
        this.miCondition = value;
    }

    /**
     * Gets the value of the complexMIFlowCondition property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getComplexMIFlowCondition() {
        return complexMIFlowCondition;
    }

    /**
     * Sets the value of the complexMIFlowCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setComplexMIFlowCondition(ExpressionType value) {
        this.complexMIFlowCondition = value;
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
     * Gets the value of the miConditionAttr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMIConditionAttr() {
        return miConditionAttr;
    }

    /**
     * Sets the value of the miConditionAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMIConditionAttr(String value) {
        this.miConditionAttr = value;
    }

    /**
     * Gets the value of the loopCounter property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLoopCounter() {
        return loopCounter;
    }

    /**
     * Sets the value of the loopCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLoopCounter(BigInteger value) {
        this.loopCounter = value;
    }

    /**
     * Gets the value of the miOrdering property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMIOrdering() {
        if (miOrdering == null) {
            return "Parallel";
        } else {
            return miOrdering;
        }
    }

    /**
     * Sets the value of the miOrdering property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMIOrdering(String value) {
        this.miOrdering = value;
    }

    /**
     * Gets the value of the miFlowCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMIFlowCondition() {
        if (miFlowCondition == null) {
            return "All";
        } else {
            return miFlowCondition;
        }
    }

    /**
     * Sets the value of the miFlowCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMIFlowCondition(String value) {
        this.miFlowCondition = value;
    }

    /**
     * Gets the value of the complexMIFlowConditionAttr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplexMIFlowConditionAttr() {
        return complexMIFlowConditionAttr;
    }

    /**
     * Sets the value of the complexMIFlowConditionAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplexMIFlowConditionAttr(String value) {
        this.complexMIFlowConditionAttr = value;
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
