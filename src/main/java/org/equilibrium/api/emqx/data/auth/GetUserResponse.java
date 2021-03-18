package org.equilibrium.api.emqx.data.auth;

public class GetUserResponse {

    private GetUsersResponse.UserData data;
    private Integer code;

    public GetUsersResponse.UserData getData() {
        return data;
    }

    public void setData(GetUsersResponse.UserData data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
