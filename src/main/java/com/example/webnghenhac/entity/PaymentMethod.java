package com.example.webnghenhac.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PaymentMethod")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 255)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "image", length = 255, nullable = false)
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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