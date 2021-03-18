package org.equilibrium.api.emqx.data.rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.equilibrium.api.emqx.data.actions.ActionGetResponse;

import java.util.List;

public class UpdateRuleRequest {

    @JsonProperty("rawsql")
    private String rawSQL;
    private List<ActionGetResponse.ActionData> actions;
    private String description;

    public String getRawSQL() {
        return rawSQL;
    }

    public void setRawSQL(String rawSQL) {
        this.rawSQL = rawSQL;
    }

    public List<ActionGetResponse.ActionData> getActions() {
        return actions;
    }

    public void setActions(List<ActionGetResponse.ActionData> actions) {
        this.actions = actions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
