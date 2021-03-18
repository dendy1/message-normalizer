package org.equilibrium.api.emqx.data.auth;

import java.util.Map;

public class CreateUserResponse {

    private Map<String, String> data;
    private Integer code;

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}