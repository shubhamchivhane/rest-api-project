package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.Cart;

public interface CartService {

	Cart saveCart(Cart cart);
	Optional<Cart> getCart(int id);
	List<Cart> getAllCart();
	List<Cart> getCartByUserId(int id);

	
	
	
}
