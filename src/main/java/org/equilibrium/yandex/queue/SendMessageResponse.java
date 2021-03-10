package org.equilibrium.yandex.queue;

public class SendMessageResponse {

    private String md5OfMessageAttributes;
    private String md5OfMessageBody;
    private String messageId;
    private String sequenceNumber;

    public SendMessageResponse() {
    }

    public SendMessageResponse(String md5OfMessageAttributes, String md5OfMessageBody, String messageId, String sequenceNumber) {
        this.md5OfMessageAttributes = md5OfMessageAttributes;
        this.md5OfMessageBody = md5OfMessageBody;
        this.messageId = messageId;
        this.sequenceNumber = sequenceNumber;
    }

    public String getMd5OfMessageAttributes() {
        return md5OfMessageAttributes;
    }

    public void setMd5OfMessageAttributes(String md5OfMessageAttributes) {
        this.md5OfMessageAttributes = md5OfMessageAttributes;
    }

    public String getMd5OfMessageBody() {
        return md5OfMessageBody;
    }

    public void setMd5OfMessageBody(String md5OfMessageBody) {
        this.md5OfMessageBody = md5OfMessageBody;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
