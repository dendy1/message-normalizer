package org.equilibrium.api.emqx.data.acl;

import java.util.List;
import java.util.Map;

public class GetACLRulesResponse {

    private Map<String, String> meta;
    private List<ACLRuleData> data;
    private Integer code;

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public List<ACLRuleData> getData() {
        return data;
    }

    public void setData(List<ACLRuleData> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static class ACLRuleData {
        private String topic;
        private String login;
        private String action;
        private Boolean allow;

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public Boolean getAllow() {
            return allow;
        }

        public void setAllow(Boolean allow) {
            this.allow = allow;
        }
    }
}
