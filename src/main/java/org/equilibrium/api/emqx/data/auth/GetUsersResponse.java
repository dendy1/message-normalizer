package org.equilibrium.api.emqx.data.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class GetUsersResponse {

    private Map<String, String> meta;
    private List<UserData> data;
    private Integer code;

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static class UserData {

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
}
