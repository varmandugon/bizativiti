package com.fing.pis.bizativiti.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Records")
@XmlSeeAlso({ PluginRecord.class })
public class JaxbList<T> {
    protected List<T> records = new ArrayList<T>();

    public JaxbList() {}

    public JaxbList(List<T> list) {
        this.records = list;
    }

    @XmlMixed
    public List<T> getRecords() {
        return records;
    }
}
