package fr.archiflower.cart.dto;

public class CartItemRequest {

    private String flower_id;

    private Integer quantity;

    public CartItemRequest() {
    }

    public CartItemRequest(String flower_id, Integer quantity) {
        this.flower_id = flower_id;
        this.quantity = quantity;
    }

    public String getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(String flower_id) {
        this.flower_id = flower_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
