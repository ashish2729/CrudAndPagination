package com.categoryProduct.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.categoryProduct.model.Product;

public interface ProductService {
	public Page<Product> findAll(Pageable pageable);

	public Product saveProduct(Product product);

	public <optional> Product getProductById(Integer Id);

	public void deleteProduct(Integer id);

}
