package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class AuthorTaiCreationRequest {
    @NotBlank(message = "FULL_NAME_REQUIRED")
    @Size(max = 255, message = "FULL_NAME_TOO_LONG")
    private String fullName;

    private LocalDate birthday;

    @NotBlank(message = "DESCRIPTION_REQUIRED")
    @Size(max = 255, message = "DESCRIPTION_TOO_LONG")
    private String description;

    @NotBlank(message = "IMAGE_REQUIRED")
    @Size(max = 255, message = "IMAGE_TOO_LONG")
    private String image;

    private boolean isPublic = true;

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
}
