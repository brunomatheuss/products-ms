package com.bruno.demo.service;

import java.util.List;

import com.bruno.demo.entity.Product;

public interface ProductService {

	public Object findById(String id);
	
	public List<Product> findAll();
	
	public Product save(Product produto);
	
	public void update(String id, Product produto);
	
}
