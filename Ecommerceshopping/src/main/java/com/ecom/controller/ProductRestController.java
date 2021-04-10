package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
	
		try {
			Product products=service.saveProduct(product);
			return  new ResponseEntity<Product>(products, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct()
	{
		  List<Product> products= service.getAllProduct();
		  System.out.println(products);
		  return  new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
