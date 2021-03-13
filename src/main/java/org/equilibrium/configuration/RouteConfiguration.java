package org.equilibrium.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RouteConfiguration {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("project_id")
    private String projectId;

    private Map<String, String> routes;

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

    public Map<String, String> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, String> routes) {
        this.routes = routes;
    }
}
