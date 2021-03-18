package org.equilibrium.api.emqx.data.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserRequest {

    private String password;

    @JsonProperty("is_superuser")
    private Boolean isSuperuser;

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
