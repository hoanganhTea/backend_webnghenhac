package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class AuthorTaiUpdateRequest {
    @Size(max = 255, message = "FULL_NAME_TOO_LONG")
    private String fullName;

    private LocalDate birthday;

    @Size(max = 255, message = "DESCRIPTION_TOO_LONG")
    private String description;

    private Boolean isPublic;

    @Size(max = 255, message = "IMAGE_URL_TOO_LONG")
    private String image; // Thêm trường image

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

    public Boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getImage() { // Getter cho image
        return image;
    }

    public void setImage(String image) { // Setter cho image
        this.image = image;
    }
}
