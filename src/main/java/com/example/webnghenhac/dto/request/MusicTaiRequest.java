package com.example.webnghenhac.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public class MusicTaiRequest {
    @NotNull(message = "AUTHOR_ID_REQUIRED")
    private UUID authorId;

    @NotBlank(message = "NAME_REQUIRED")
    @Size(max = 255, message = "NAME_TOO_LONG")
    private String name;

    @NotBlank(message = "LINK_REQUIRED")
    @Size(max = 255, message = "LINK_TOO_LONG")
    private String link;

    @NotBlank(message = "DESCRIPTION_REQUIRED")
    @Size(max = 255, message = "DESCRIPTION_TOO_LONG")
    private String description;

    @NotBlank(message = "IMAGE_REQUIRED")
    @Size(max = 255, message = "IMAGE_TOO_LONG")
    private String image;

    private boolean isPublic;
    private boolean premium = true;
    private Float purchasePrice;

    // Getters and Setters
    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
