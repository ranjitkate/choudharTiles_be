package com.example.choudharTiles.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    @Column(nullable = false, unique = true)
    private String name;
    private String code;

    private String description; // Extra field from Angular UI
    private String imageUrl; // If later you want to store image link
    private boolean active; // Status toggle

    // Default constructor
    public Category() {
    }

    // All-Args constructor
    public Category(Long id, String name, String code, String description, String imageUrl, boolean active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.imageUrl = imageUrl;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
