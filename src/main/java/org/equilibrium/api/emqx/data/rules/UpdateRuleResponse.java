package org.equilibrium.api.emqx.data.rules;

public class UpdateRuleResponse {

    private Integer code;
    private CreateRuleResponse.RuleData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CreateRuleResponse.RuleData getData() {
        return data;
    }

    public void setData(CreateRuleResponse.RuleData data) {
        this.data = data;
    }
}
