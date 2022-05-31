package com.categoryProduct.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.categoryProduct.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Serializable> {

	public Product findById(Integer Id);

}
