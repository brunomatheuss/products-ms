package com.bruno.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bruno.demo.dto.ProductDTO;
import com.bruno.demo.entity.Product;
import com.bruno.demo.exception.CustomException;

public interface ProductService {

	public ResponseEntity<Product> findById(String id) throws CustomException;
	
	public List<Product> findAll();
	
	public List<ProductDTO.Response.Search> search(String q, Double min_price, Double max_price) throws CustomException;
	
	public ResponseEntity<Product> save(Product produto);
	
	public Product update(String id, Product produto) throws CustomException;
	
	public void delete(String id) throws CustomException;
	
}
