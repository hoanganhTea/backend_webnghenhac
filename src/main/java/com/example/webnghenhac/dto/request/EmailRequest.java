package com.example.webnghenhac.dto.request;

public class EmailRequest {
    private String email;

    // Constructor không tham số (cần thiết cho Jackson khi nhận request JSON)
    public EmailRequest() {
    }

    // Constructor có tham số
    public EmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
