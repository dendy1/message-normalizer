package org.equilibrium.api.emqx.data.actions;

import java.util.Map;

public class ActionGetResponse {

    private Integer code;
    private ActionData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ActionData getData() {
        return data;
    }

    public void setData(ActionData data) {
        this.data = data;
    }


    public class ActionData {

        private String types;
        private Map<String, String> title;
        private Map<String, String> params;
        private Map<String, String> description;
        private String app;

        public String getTypes() {
            return types;
        }

        public void setTypes(String types) {
            this.types = types;
        }

        public Map<String, String> getTitle() {
            return title;
        }

        public void setTitle(Map<String, String> title) {
            this.title = title;
        }

        public Map<String, String> getParams() {
            return params;
        }

        public void setParams(Map<String, String> params) {
            this.params = params;
        }

        public Map<String, String> getDescription() {
            return description;
        }

        public void setDescription(Map<String, String> description) {
            this.description = description;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }
    }

}
