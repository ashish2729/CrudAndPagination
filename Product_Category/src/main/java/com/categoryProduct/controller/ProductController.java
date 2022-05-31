package com.categoryProduct.controller;

import java.util.Collections;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.categoryProduct.model.Product;
import com.categoryProduct.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * This method is used to get all the product details
	 * 
	 */
	
	@GetMapping("product/getAll")
    public Page<Product> getProductList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Pageable paging = PageRequest.of(page, size);
        return productService.findAll(paging);
    }

	/*
	 * This method is used to get the product details by using id
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		Product product = productService.getProductById(id);
		logger.info("Product Rest Controller Implementation : getProductById() method");
		return ResponseEntity.ok().body(product);
	}

	/*
	 * This method is used to store the product details .
	 */

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product, HttpServletRequest request)
			throws Exception {
		Product createdProduct = this.productService.saveProduct(product);
		logger.info("Product Rest Controller Implementation : createProduct() method");
		return ResponseEntity.ok().body(createdProduct);
	}

	/*
	 * This method is used to delete the product details of user by using id.
	 */

	@DeleteMapping("/products/{id}")
	public Map<String, String> deleteProductById(@PathVariable("id") Integer id) throws Exception {
		Product product = productService.getProductById(id);
		logger.info("Product Rest Controller Implementation : deleteProductById() method");
		if (product != null) {
			productService.deleteProduct(id);
			return Collections.singletonMap("success", "Record Deleted Successfully");
		} else {
			return Collections.singletonMap("fail", "Something is wrong");
		}

	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable("id") Integer id, @RequestBody Product product) {
		Product products = productService.getProductById(id);
		products.setProductId(product.getProductId());
		products.setAmount(product.getAmount());
		products.setProductDescription(product.getProductDescription());
		products.setProductName(product.getProductName());
		products.setQuantity(product.getQuantity());
		products.setStatus(product.getStatus());
		Product products2 = productService.saveProduct(products);
		return ResponseEntity.ok().body(products2);
	}

}
