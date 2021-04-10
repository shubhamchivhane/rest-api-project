package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.Category;

public interface CategoryService {

	Integer saveCategory(Category category);
	Optional<Category> getCategory(int id);
	List<Category> getAllCategory();
}
