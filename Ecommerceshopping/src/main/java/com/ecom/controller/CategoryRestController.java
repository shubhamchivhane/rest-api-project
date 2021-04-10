package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exception.CategoryNotFoundException;
import com.ecom.model.Category;
import com.ecom.service.CategoryService;

@RestController
@RequestMapping("/categoryapi")
public class CategoryRestController {

	@Autowired
	private CategoryService service;
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat)
	{
	
		try {
			int id=service.saveCategory(cat);
			return  new ResponseEntity<Category>(cat, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable int id)
	{
			Category cat =service.getCategory(id).get();
			return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/category/")
	public ResponseEntity<List<Category>> getAllcategory()
	{
	   try {
		List<Category> lists= service.getAllCategory();
		return new ResponseEntity<List<Category>>(lists, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	   
	}
}
