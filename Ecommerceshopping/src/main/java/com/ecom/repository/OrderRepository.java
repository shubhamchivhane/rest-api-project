package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query("Select o from Order o where o.id=:orderId and o.user.id=:userId")
	Order getOrderByUserIdAndOrderId(int userId,int orderId );

}
