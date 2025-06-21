package fr.archiflower.cart.dto;

public class CartItemDeleteRequest {

    private String flower_id;

    public CartItemDeleteRequest() {
    }

    public CartItemDeleteRequest(String flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(String flower_id) {
        this.flower_id = flower_id;
    }
}
