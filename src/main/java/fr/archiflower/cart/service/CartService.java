package fr.archiflower.cart.service;

import fr.archiflower.cart.dto.CartOrderResponse;
import fr.archiflower.cart.entity.Cart;
import fr.archiflower.cart.entity.Flower;
import fr.archiflower.cart.entity.Item;
import fr.archiflower.cart.entity.Order;
import fr.archiflower.cart.repository.CartRepository;
import fr.archiflower.cart.repository.ItemRepository;
import fr.archiflower.cart.request.FlowerRequest;
import fr.archiflower.cart.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FlowerRequest flowerRequest;

    @Autowired
    private OrderRequest orderRequest;


    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    public Cart getCartById(UUID cart_id) {
        Cart cart = cartRepository.findById(cart_id).orElseThrow();
        List<Item> items = cart.getItems();
        for (Item item : items) {
            Flower flower = flowerRequest.getFlowerById(item.getFlower_id());
            item.setFlower(flower);
        }
        return cart;
    }

    public Cart addItemInCart(UUID cart_id, UUID flower_id, Integer quantity) {

        // Get cart
        Cart cart = cartRepository.findById(cart_id).orElseThrow();
        List<Item> items = cart.getItems();

        if (quantity <= 0) return cart;

        for (Item item: items) {
            if(item.getFlower_id().equals((flower_id))) {
                item.setQuantity(item.getQuantity() + quantity);
                itemRepository.save(item);
                return cart;
            }
        }

        // Create item with flower
        Item item = new Item(flower_id, quantity);
        itemRepository.save(item);

        // Add item in item's cart
        items.add(item);

        // Save new items list
        cart.setItems(items);
        return cartRepository.save(cart);
    }

    public Cart updateItemQuantityInCart(UUID cart_id, UUID flower_id, Integer quantity) {
        // Get cart
        Cart cart = cartRepository.findById(cart_id).orElseThrow();
        List<Item> items = cart.getItems();

        if (quantity <= 0) return cart;

        for (Item item: items) {
            if(item.getFlower_id().equals((flower_id))) {
                item.setQuantity(quantity);
                itemRepository.save(item);
            }
        }
        return this.getCartById(cart_id);
    }

    public Cart removeItemInCart(UUID cart_id, UUID flower_id) {
        // Get cart
        Cart cart = cartRepository.findById(cart_id).orElseThrow();
        List<Item> items = cart.getItems();

        for (Item item: items) {
            if(item.getFlower_id().equals((flower_id))) {
                items.remove(item);
                cart.setItems(items);
                cartRepository.save(cart);
                itemRepository.delete(item);
                return cart;
            }
        }

        return cart;
    }

    public CartOrderResponse confirmCart(UUID cart_id) {
        // Get cart
        Cart cart = this.getCartById(cart_id);

        if(cart.getItems().isEmpty()) {
            return new CartOrderResponse(cart, null);
        }

        // Appel vers Order pour créer la commande
        Order order = orderRequest.createOrder(cart);

        // Vidage du panier
        List<Item> items = cart.getItems();
        cart.setItems(new ArrayList<>());
        itemRepository.deleteAll(items);

        return new CartOrderResponse(cart, order);
    }

}
