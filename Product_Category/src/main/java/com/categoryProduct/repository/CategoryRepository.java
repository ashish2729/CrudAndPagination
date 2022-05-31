package com.categoryProduct.repository;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.categoryProduct.model.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Serializable> {

	public Category findById(Integer Id);

}
