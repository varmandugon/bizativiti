package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelMessageStartEvent extends MetamodelEvent {
    private String trigger;
    private String messageId;

    public MetamodelMessageStartEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String sTrigger, String sMessageId) {
        super(id, name, description, x, y, width, height, lane);
        setTrigger(sTrigger);
        setMessageId(sMessageId);
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}