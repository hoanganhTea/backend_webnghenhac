package com.example.webnghenhac.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Author")
public class AuthorTai {

    @Id
    @GeneratedValue(generator = "UUID") // Sử dụng UUID Generator
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "author_id", length = 36, updatable = false, nullable = false)
    private UUID id;

    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "describe", length = 255, nullable = false)
    private String description;

    @Column(name = "image", length = 255) // Thêm cột ảnh
    private String image;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "created_at", columnDefinition = "DATETIME", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
