package fr.archiflower.cart.controller;

import fr.archiflower.cart.dto.CartItemDeleteRequest;
import fr.archiflower.cart.dto.CartItemRequest;
import fr.archiflower.cart.dto.CartOrderResponse;
import fr.archiflower.cart.entity.Cart;
import fr.archiflower.cart.entity.Flower;
import fr.archiflower.cart.request.FlowerRequest;
import fr.archiflower.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class CartController
{
    @Autowired
    private CartService cartService;

    // Créer un panier
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/cart")
    public Cart createCart() {
        return cartService.createCart();
    }

    // Ajouter un objet au panier
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/cart/{id}")
    public Cart addItem(@PathVariable(name = "id") UUID cart_id, @RequestBody CartItemRequest requestBody) {
        return cartService.addItemInCart(cart_id, UUID.fromString(requestBody.getFlower_id()), requestBody.getQuantity());
    }

    // Set quantity un objet du panier
    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/api/cart/{id}")
    public Cart updateItemQuantity(@PathVariable(name = "id") UUID cart_id, @RequestBody CartItemRequest requestBody) {
        return cartService.updateItemQuantityInCart(cart_id, UUID.fromString(requestBody.getFlower_id()), requestBody.getQuantity());
    }


    // Retirer un objet du panier
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/api/cart/{id}")
    public Cart removeItem(@PathVariable(name = "id") UUID cart_id, @RequestParam(name = "flower_id") String flower_id) {
        return cartService.removeItemInCart(cart_id, UUID.fromString(flower_id));
    }

    // Obtenir le panier
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/cart/{id}")
    public Cart getCart(@PathVariable(name = "id") UUID cart_id) {
        return cartService.getCartById(cart_id);
    }


    // Valider un panier...
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/cart/{id}/confirm")
    public CartOrderResponse confirmCart(@PathVariable(name = "id") UUID cart_id) {
        return cartService.confirmCart(cart_id);
    }

}
