package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.NotBlank;

public class PaymentMethodUpdateRequest {
    @NotBlank(message = "NAME_CANNOT_BE_BLANK")
    private String name;

    @NotBlank(message = "IMAGE_CANNOT_BE_BLANK")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}