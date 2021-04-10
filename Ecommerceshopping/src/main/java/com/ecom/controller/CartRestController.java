package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.Cart;
import com.ecom.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartRestController {

	
	@Autowired
	private CartService service;
	
	@PostMapping
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
	{
	
		try {
			Cart carts=service.saveCart(cart);
			return  new ResponseEntity<Cart>(carts, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
