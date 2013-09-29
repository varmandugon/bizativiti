package com.fing.pis.bizativiti.common.metamodel;

public class MetamodelIntermediateMessageCatch extends MetamodelIntermediate {

    private String messageId;

    public MetamodelIntermediateMessageCatch(String id, String name, String description, double x, double y,
            double width, double height, String lane, boolean adj, String ref, String messID) {
        super(id, name, description, x, y, width, height, lane, adj, ref);
        this.messageId = messID;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}
