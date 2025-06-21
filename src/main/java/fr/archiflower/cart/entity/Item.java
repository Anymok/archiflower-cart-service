package fr.archiflower.cart.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true)
    private UUID id;

    @Column
    private UUID flower_id;

    @Column
    private Integer quantity;

    @Transient
    private Flower flower;

    public Item() {
    }

    public Item(UUID flower_id, Integer quantity) {
        this.flower_id = flower_id;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(UUID flower_id) {
        this.flower_id = flower_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }
}
