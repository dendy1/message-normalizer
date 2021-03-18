package org.equilibrium.api.emqx.data.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

    private String login;
    private String password;

    @JsonProperty("is_superuser")
    private Boolean isSuperuser;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(Boolean superuser) {
        isSuperuser = superuser;
    }
}
