package fr.archiflower.cart.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;

    private List<Item> items;

    private LocalDateTime create_date;

    {
        create_date = LocalDateTime.now();
        items = new ArrayList<>();
    }

    public Order() {
    }

    public Order(List<Item> items) {
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }
}
