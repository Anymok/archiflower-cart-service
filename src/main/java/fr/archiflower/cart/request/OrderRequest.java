package fr.archiflower.cart.request;

import fr.archiflower.cart.entity.Cart;
import fr.archiflower.cart.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;



@Service
public class OrderRequest {
    private final RestClient restClient = RestClient.create("https://www.epsi-projet-i1.fr");

    /**
     * API Request call order service to create and return order
     * @param cart
     * @return Order
     */
    public Order createOrder(Cart cart) {

        return restClient.post()
                .uri("/api/order")
                .body(cart)
                .retrieve()
                .body(Order.class);
    }
}
