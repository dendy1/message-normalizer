package org.equilibrium.api.yandex.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SendMessageRequest {

    @JsonProperty("queue_name")
    private String queueName;

    @JsonProperty("message_body")
    private String messageBody;

    @JsonProperty("attributes")
    private Map<String, String> attributes;

    public SendMessageRequest(String queueName, String messageBody, Map<String, String> attributes) {
        this.queueName = queueName;
        this.messageBody = messageBody;
        this.attributes = attributes;
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

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
