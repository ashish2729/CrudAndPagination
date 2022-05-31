package com.categoryProduct.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.categoryProduct.model.Category;

public interface CategoryService {
	public <optional> Category getCategoryById(Integer Id);

	public void deleteCategory(Integer id);

	public Category saveCategory(Category category);

	public Page<Category> findAll(Pageable pageable);
}
