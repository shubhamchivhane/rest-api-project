package com.ecom.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Cart;
import com.ecom.repository.CartRepository;
import com.ecom.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository repo;
	
	@Override
	public Cart saveCart(Cart cart) {
		
		return repo.save(cart);
	}

	@Override
	public Optional<Cart> getCart(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Cart> getAllCart() {
		
		return repo.findAll();
	}

	@Override
	public List<Cart> getCartByUserId(int id) {
		
		return repo.findByUser(id);
	}

}
