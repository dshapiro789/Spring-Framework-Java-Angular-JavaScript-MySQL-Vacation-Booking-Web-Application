package com.example.d288_project.services;

import com.example.d288_project.entities.Cart;
import com.example.d288_project.entities.CartItem;
import com.example.d288_project.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Cart cart;

    private Set<CartItem> cartItems;

}