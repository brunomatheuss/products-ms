package com.bruno.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bruno.demo.entity.Product;
import com.bruno.demo.repository.ProductRepository;
import com.bruno.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Object findById(String id){
		if(productRepository.findById(id).isEmpty()) {
			return new ResponseEntity<Object>("Product not found!", HttpStatus.NOT_FOUND);
		}
		return productRepository.findById(id).get();
	}
	
	@Override
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	@Override
	public Product save(Product produto){
		return productRepository.save(produto);
	}
	
	@Override
	public void update(String id, Product produto){
		produto.setId(id);
		productRepository.save(produto);
	}
	
}
