package org.equilibrium.api.yandex.data.message;

public class YandexMessagePayload {

    private String userId;
    private String projectId;
    private String topic;
    private String payload;
    private Long dateTimeStamp;

    public YandexMessagePayload(String userId, String projectId, String topic, String payload, Long dateTimeStamp) {
        this.userId = userId;
        this.projectId = projectId;
        this.topic = topic;
        this.payload = payload;
        this.dateTimeStamp = dateTimeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(Long dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }
}
