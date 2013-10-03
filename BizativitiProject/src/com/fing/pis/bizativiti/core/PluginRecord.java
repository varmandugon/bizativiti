package com.fing.pis.bizativiti.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PluginRecord")
@XmlAccessorType(XmlAccessType.FIELD)
public class PluginRecord {

    @XmlElement
    private String Name;

    @XmlElement
    private String Jar;

    @XmlElement
    private String ClassName;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJar() {
        return Jar;
    }

    public void setJar(String jar) {
        Jar = jar;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

}
