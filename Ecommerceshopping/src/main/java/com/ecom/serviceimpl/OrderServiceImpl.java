package com.ecom.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.constant.OrderStatus;
import com.ecom.model.Order;
import com.ecom.repository.OrderRepository;
import com.ecom.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Override
	public Order saveOrder(Order order) {
		
		return repo.save(order);
	}

	@Override
	public Order getOrder(int orderId) {
		
		return repo.getOne(orderId);
	}

	@Override
	public void deleteOrder(int orderId) {
		
		Order order=getOrder(orderId);
		if(order != null)
			order.setIsOrderConfirm(OrderStatus.CANCELLED.getValue());
		saveOrder(order);
	}

	@Override
	public Order cancelOrder(int userId, int orderId) {
		 Order order=repo.getOrderByUserIdAndOrderId(userId, orderId);
		 if(order != null)
		 {
			 order.setIsOrderConfirm(OrderStatus.CANCELLED.getValue());
		 }
		 System.out.println("order list in service tbl"+order);
		return saveOrder(order);
	}


}
