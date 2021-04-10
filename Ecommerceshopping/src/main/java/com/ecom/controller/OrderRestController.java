package com.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.constant.OrderStatus;
import com.ecom.model.Cart;
import com.ecom.model.Order;
import com.ecom.service.CartService;
import com.ecom.service.OrderService;

@RequestMapping("/order")
@RestController
public class OrderRestController {

	@Autowired
	private OrderService service;

	@Autowired
	private CartService cartService;

	@PostMapping("/placeorder/{userId}")
	public String orderPlaced(@PathVariable int userId) {

		List<Cart> carts = cartService.getCartByUserId(userId);

		System.out.println(carts);
		Order order = new Order();
		order.setIsOrderConfirm(OrderStatus.ORDERED.getValue());
		int cartId = 0;
		for (Cart list : carts) {
			order.setTotalPrice(list.getTotalOrderPrice());
			order.setUser(list.getUser());
			cartId = list.getId();

		}
		Optional<Cart> opt = cartService.getCart(cartId);
		if (opt.isPresent()) {
			order.setCart(opt.get());
		}

		System.out.println("order information :" + order);
		int id = saveOrder(order);

		return "Order Created " + id;

	}

	public int saveOrder(Order order) {
		Order ord = service.saveOrder(order);
		return ord.getId();
	}
	
	@PostMapping("/cancelorder/{userId}/{orderId}")
	public Order cancelOrder(@PathVariable int userId, @PathVariable int orderId) 
	{
		System.out.println(userId+"   "+orderId);
		Order order =removeOrder (userId,orderId);
		return order ;
	}
	
	public Order removeOrder (int userId,int orderId)
	{
		Order order=service.cancelOrder(userId, orderId);
		return order;
	}
}
