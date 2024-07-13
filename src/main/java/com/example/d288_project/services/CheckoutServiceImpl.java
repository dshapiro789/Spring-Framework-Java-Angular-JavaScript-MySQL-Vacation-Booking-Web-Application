package com.example.d288_project.services;

import com.example.d288_project.dao.CartItemRepository;
import com.example.d288_project.dao.CartRepository;
import com.example.d288_project.entities.Cart;
import com.example.d288_project.entities.CartItem;
import com.example.d288_project.entities.Customer;
import com.example.d288_project.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    // constructor
    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();
        // create order tracking number
        String orderTrackingNumber = UUID.randomUUID().toString();
        // set order tracking number
        cart.setOrderTrackingNumber(orderTrackingNumber);
        // set order status
        cart.setStatus(StatusType.ordered);
        // add item(s) to cart and save each CartItem
        cartItems.forEach(cart::add);
        // saves cart data
        cartRepository.save(cart);
        // returns the purchase response
        return new PurchaseResponse(orderTrackingNumber);
    }
}