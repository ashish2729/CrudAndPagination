package com.categoryProduct.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.categoryProduct.exception.CRUDException;
import com.categoryProduct.model.Product;
import com.categoryProduct.repository.ProductRepository;
import com.categoryProduct.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository repository;

//	@Override
//	public Iterable<Product> getAllProduct() {
//		logger.info("Product Service Implementation : getAllProduct() method");
//		return repository.findAll();
//	}
	
	@Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

	@Override
	@Transactional
	public Product saveProduct(Product product) {
		logger.info("Product Service Implementation : saveProduct() method");
		return repository.save(product);
	}

	@Override
	public Product getProductById(Integer Id) {
		logger.info("Product Service Implementation : getProductById() method");
		Product product = repository.findById(Id);
		if (product == null) {
			throw new CRUDException("Product id " + Id + " incorrect..");
		}
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		logger.info("Product Service Implementation : deleteProduct() method");
		repository.deleteById(id);
	}

}
