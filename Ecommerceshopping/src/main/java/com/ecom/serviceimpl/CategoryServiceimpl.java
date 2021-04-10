package com.ecom.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exception.CategoryNotFoundException;
import com.ecom.model.Category;
import com.ecom.repository.CategoryRepository;
import com.ecom.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public Integer saveCategory(Category category) {
		
		return repo.save(category).getId();
	}

	@Override
	public Optional<Category> getCategory(int id) {
		
		Optional<Category> cat = repo.findById(id);
		if (cat.isPresent()) {
			return cat;
		} else {
			throw new CategoryNotFoundException("Category with id " + id + " not found");
		}
	}

	@Override
	public List<Category> getAllCategory() {
		
		return repo.findAll();
	}

}
