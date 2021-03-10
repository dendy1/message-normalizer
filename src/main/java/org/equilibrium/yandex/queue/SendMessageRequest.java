package org.equilibrium.yandex.queue;

public class SendMessageRequest {

    private String queueUrl;
    private String messageBody;

    //private Integer delaySeconds;
    //private Array messageAttributes;

    public String getQueueUrl() {
        return queueUrl;
    }

    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
