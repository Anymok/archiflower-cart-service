package fr.archiflower.cart.entity;

import jakarta.persistence.*;

import java.sql.Array;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true)
    private UUID id;

    @OneToMany
    private List<Item> items;

    {
        items = Collections.emptyList();
    }
    public Cart() {
    }

    public Cart(List<Item> items) {
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
}
