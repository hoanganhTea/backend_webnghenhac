// Entity: Premium
package com.example.webnghenhac.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Premium")
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "premium_id", length = 255)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "duration", nullable = false)
    private  Integer duration;

    @Column(name = "describe", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String describe;

    @Column(name = "price", nullable = false)
    private Double price;

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
