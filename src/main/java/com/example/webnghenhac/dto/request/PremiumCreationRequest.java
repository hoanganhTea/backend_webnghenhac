package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PremiumCreationRequest {
    @NotBlank(message = "NAME_CANNOT_BE_BLANK")
    private String name;

    @NotNull(message = "DURATION_CANNOT_BE_NULL")
    private Integer duration;

    @NotBlank(message = "DESCRIPTION_CANNOT_BE_BLANK")
    private String describe;

    @NotNull(message = "PRICE_CANNOT_BE_NULL")
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}