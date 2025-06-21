package fr.archiflower.cart.dto;

import fr.archiflower.cart.entity.Cart;
import fr.archiflower.cart.entity.Order;

public class CartOrderResponse {
    private Cart cart;
    private Order order;

    public CartOrderResponse(Cart cart, Order order) {
        this.cart = cart;
        this.order = order;
    }

    public Cart getCart() {
        return cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
