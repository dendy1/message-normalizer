package org.equilibrium.api.yandex.data.queue;

import java.util.Map;

public class CreateQueueRequest {

    private String queueName;
    private Map<String, String> attributes;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
