package com.example.webnghenhac.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    @Size(min = 8, max = 24, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, max = 24, message = "PASSWORD_INVALID")
    private String password;
    @NotBlank(message = "EMAIL_BLANK")
    @Email(message = "EMAIL_INVALID")
    private String email;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
