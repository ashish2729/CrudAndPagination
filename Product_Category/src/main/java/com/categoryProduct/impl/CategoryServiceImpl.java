package com.categoryProduct.impl;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.categoryProduct.exception.CRUDException;
import com.categoryProduct.model.Category;
import com.categoryProduct.model.Product;
import com.categoryProduct.repository.CategoryRepository;
import com.categoryProduct.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository repository;

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		logger.info("Category Service Implementation : saveCategory() method");
		return repository.save(category);
	}

	@Override
	public Category getCategoryById(Integer Id) {
		logger.info("Category Service Implementation : getCategoryById() method");
		Category category = repository.findById(Id);
		if (category == null) {
			throw new CRUDException("Category id " + Id + " incorrect..");
		}
		return category;
	}

	@Override
	public void deleteCategory(Integer id) {
		logger.info("Category Service Implementation : deleteCategory() method");
		repository.deleteById(id);
	}

}
