package org.equilibrium.api.emqx.data.resources;

import java.util.Map;

public class CreateResourceResponse {

    private Integer code;
    private ResourceData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResourceData getData() {
        return data;
    }

    public void setData(ResourceData data) {
        this.data = data;
    }

    public class ResourceData {
        private String id;
        private String type;
        private Map<String, String> config;
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Map<String, String> getConfig() {
            return config;
        }

        public void setConfig(Map<String, String> config) {
            this.config = config;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
