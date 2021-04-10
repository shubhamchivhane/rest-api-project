package com.ecom.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;
import com.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product saveProduct(Product product) {
		
		return repo.save(product);
	}

	@Override
	public Optional<Product> getProduct(int id) {
		Optional<Product> product=repo.findById(id);
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return repo.findAll();
	}

}
