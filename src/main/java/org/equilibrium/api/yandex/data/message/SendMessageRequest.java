package org.equilibrium.api.yandex.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendMessageRequest {

    @JsonProperty("queue_name")
    private String queueName;

    @JsonProperty("message_body")
    private String messageBody;

    public SendMessageRequest(String queueName, String messageBody) {
        this.queueName = queueName;
        this.messageBody = messageBody;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
