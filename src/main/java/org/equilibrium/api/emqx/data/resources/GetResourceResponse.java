package org.equilibrium.api.emqx.data.resources;

public class GetResourceResponse {

    private Integer code;
    private CreateResourceResponse.ResourceData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CreateResourceResponse.ResourceData getData() {
        return data;
    }

    public void setData(CreateResourceResponse.ResourceData data) {
        this.data = data;
    }
}
