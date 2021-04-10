package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.model.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("SELECT c  FROM Cart c where c.user.id=:userId")
	List<Cart> findByUser(int userId);
	
	
}
