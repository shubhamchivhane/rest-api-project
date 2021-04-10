package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.Product;

public interface ProductService {

	Product saveProduct(Product product);
	Optional<Product> getProduct(int id);
	List<Product> getAllProduct();
}
