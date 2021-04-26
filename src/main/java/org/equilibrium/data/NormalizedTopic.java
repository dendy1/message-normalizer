package org.equilibrium.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NormalizedTopic {

    @JsonProperty("username")
    private String username;

    @JsonProperty("queue_name")
    private String queueName;

    @JsonProperty("project_uuid")
    private String projectUuid;

    @JsonProperty("project_name")
    private String project;

    @JsonProperty("group_uuid")
    private String groupUuid;

    @JsonProperty("group_name")
    private String group;

    @JsonProperty("topic_uuid")
    private String topicUuid;

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    public NormalizedTopic() {
    }

    public NormalizedTopic(String username, String projectUuid, String project, String groupUuid, String group, String topicUuid, String type, String value) {
        this.username = username;
        this.projectUuid = projectUuid;
        this.project = project;
        this.groupUuid = groupUuid;
        this.group = group;
        this.topicUuid = topicUuid;
        this.type = type;
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getProjectUuid() {
        return projectUuid;
    }

    public void setProjectUuid(String projectUuid) {
        this.projectUuid = projectUuid;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getGroupUuid() {
        return groupUuid;
    }

    public void setGroupUuid(String groupUuid) {
        this.groupUuid = groupUuid;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTopicUuid() {
        return topicUuid;
    }

    public void setTopicUuid(String topicUuid) {
        this.topicUuid = topicUuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalizedTopic that = (NormalizedTopic) o;
        return Objects.equals(username, that.username) && Objects.equals(projectUuid, that.projectUuid) && Objects.equals(project, that.project) && Objects.equals(groupUuid, that.groupUuid) && Objects.equals(group, that.group) && Objects.equals(topicUuid, that.topicUuid) && Objects.equals(type, that.type) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, projectUuid, project, groupUuid, group, topicUuid, type, value);
    }

    public Map<String, String> getYandexQueueAttributes() {
        Map<String, String> attributes = new HashMap<>();

        attributes.put("username", username);
        attributes.put("project_uuid", projectUuid);
        attributes.put("group_uuid", groupUuid);
        attributes.put("topic_uuid", topicUuid);

        return attributes;
    }
}
