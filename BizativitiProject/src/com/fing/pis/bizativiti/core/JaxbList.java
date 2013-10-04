package com.fing.pis.bizativiti.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Records")
@XmlSeeAlso({ PluginRecord.class })
public class JaxbList {

    protected List<PluginRecord> records = new ArrayList<PluginRecord>();

    public JaxbList() {}

    public JaxbList(List<PluginRecord> list) {
        this.records = list;
    }

    public List<PluginRecord> getRecords() {
        return records;
    }

    public void setRecords(List<PluginRecord> records) {
        this.records = records;
    }

}
