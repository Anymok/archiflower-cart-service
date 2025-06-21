package fr.archiflower.cart.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Flower {

    private UUID id;

    private String name;

    private String description;

    private Integer price;

    private String color;

    private LocalDateTime create_date;

    public Flower() {
    }

    public Flower(String name, String description, Integer price, String color) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.color = color;
        this.create_date = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
