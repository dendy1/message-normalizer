package org.equilibrium.api.emqx.data.rules;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class CreateRuleRequest {

    @JsonProperty("rawsql")
    private String rawSQL;
    private List<RuleAction> actions;
    private String description;

    public String getRawSQL() {
        return rawSQL;
    }

    public void setRawSQL(String rawSQL) {
        this.rawSQL = rawSQL;
    }

    public List<RuleAction> getActions() {
        return actions;
    }

    public void setActions(List<RuleAction> actions) {
        this.actions = actions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class RuleAction {

        private String name;
        private Map<String, String> params;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, String> getParams() {
            return params;
        }

        public void setParams(Map<String, String> params) {
            this.params = params;
        }
    }
}
