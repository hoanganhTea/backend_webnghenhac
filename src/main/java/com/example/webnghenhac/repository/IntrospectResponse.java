package com.example.webnghenhac.repository;

public class IntrospectResponse {
    boolean valid;

    public IntrospectResponse(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public IntrospectResponse() {
    }
}
