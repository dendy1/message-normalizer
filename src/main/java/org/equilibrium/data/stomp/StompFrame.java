package org.equilibrium.data.stomp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StompFrame {

    private String ack;
    private String receipt;
    private String body;
    private String destination;
    private Map<String, String> headers;
    private String id;
    private String transaction;
    private String command;

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "StompFrame{" +
                "ack='" + ack + '\'' +
                ", receipt='" + receipt + '\'' +
                ", body='" + body + '\'' +
                ", destination='" + destination + '\'' +
                ", headers=" + headers +
                ", id='" + id + '\'' +
                ", transaction='" + transaction + '\'' +
                ", command='" + command + '\'' +
                '}';
    }
}
