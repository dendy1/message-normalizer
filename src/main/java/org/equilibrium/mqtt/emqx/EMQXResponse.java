package org.equilibrium.mqtt.emqx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.equilibrium.mqtt.MqttResource;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EMQXResponse {

    private String username;

    private String topic;

    private Long timestamp;

    private Integer qos;

    @JsonProperty("publish_received_at")
    private Long publishReceivedAt;

    @JsonProperty("pub_props")
    private Map<String, String> publishProps;

    private String peerhost;

    private Map<String, String> payload = new HashMap<>();

    private String node;

    private Map<String, String> metadata;

    private String id;

    private Headers headers;

    private Map<String, Boolean> flags;

    private String event;

    private String clientId;

    public Map<String, String> getPayload() {
        return payload;
    }

    public String getPayLoadString() {
        try {
            return MqttResource.objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            MqttResource.logger.error("", e);
        }
        return null;
    }

    @JsonSetter("payload")
    public void setPayload(String payload) {
        try {
            this.payload = MqttResource.objectMapper.readValue(payload, new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            MqttResource.logger.error("", e);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }

    public Long getPublishReceivedAt() {
        return publishReceivedAt;
    }

    public void setPublishReceivedAt(Long publishReceivedAt) {
        this.publishReceivedAt = publishReceivedAt;
    }

    public Map<String, String> getPublishProps() {
        return publishProps;
    }

    public void setPublishProps(Map<String, String> publishProps) {
        this.publishProps = publishProps;
    }

    public String getPeerhost() {
        return peerhost;
    }

    public void setPeerhost(String peerhost) {
        this.peerhost = peerhost;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Map<String, Boolean> getFlags() {
        return flags;
    }

    public void setFlags(Map<String, Boolean> flags) {
        this.flags = flags;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "EMQXResponse{" +
                "username='" + username + '\'' +
                ", topic='" + topic + '\'' +
                ", timestamp=" + timestamp +
                ", qos=" + qos +
                ", publishReceivedAt=" + publishReceivedAt +
                ", publishProps=" + publishProps +
                ", peerhost='" + peerhost + '\'' +
                ", payload=" + payload +
                ", node='" + node + '\'' +
                ", metadata=" + metadata +
                ", id='" + id + '\'' +
                ", headers=" + headers +
                ", flags=" + flags +
                ", event='" + event + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
