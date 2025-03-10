package com.example.webnghenhac.dto.request;

public class IntrospectRequest {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IntrospectRequest(String token) {
        this.token = token;
    }

    public IntrospectRequest() {
    }
}
