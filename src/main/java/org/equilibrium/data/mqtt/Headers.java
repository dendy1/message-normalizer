package org.equilibrium.data.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class Headers {

    private String username;

    private String protocol;

    @JsonProperty("proto_ver")
    private Integer protocolVersion;

    private Map<String, Object> properties;

    private String peerhost;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(Integer protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String getPeerhost() {
        return peerhost;
    }

    public void setPeerhost(String peerhost) {
        this.peerhost = peerhost;
    }
}
