package com.ecom.service;

import com.ecom.model.Order;

public interface OrderService {

	Order saveOrder(Order order);
	Order getOrder(int orderId);
	void deleteOrder(int orderId);
	Order cancelOrder(int userId,int orderId);
}
