package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelMessageStartEvent extends MetamodelStartEvent {

    private String messageId;

    public MetamodelMessageStartEvent(String id, String name, String description, double x, double y, double width,
            double height, String lane, String trigger, String messageId) {
        super(id, name, description, x, y, width, height, lane, trigger);
        setMessageId(messageId);
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}