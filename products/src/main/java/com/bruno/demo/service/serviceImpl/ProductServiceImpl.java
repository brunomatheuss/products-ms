package com.bruno.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bruno.demo.dto.ProductDTO;
import com.bruno.demo.entity.Product;
import com.bruno.demo.exception.CustomException;
import com.bruno.demo.repository.ProductRepository;
import com.bruno.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ResponseEntity<Product> findById(String id) throws CustomException{
		if(productRepository.findById(id).isEmpty()) {
			throw new CustomException("Product not found!", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id).get());
	}
	
	@Override
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	@Override
	public List<ProductDTO.Response.Search> search(String q, Double min_price, Double max_price) throws CustomException{
		return productRepository.search(q, min_price, max_price);
	}
	
	@Override
	public ResponseEntity<Product> save(Product produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(produto));
	}
	
	@Override
	public Product update(String id, Product produto) throws CustomException{
		if(productRepository.findById(id).isEmpty()) {
			throw new CustomException("Product not found!", HttpStatus.NOT_FOUND);
		}
		produto.setId(id);
		productRepository.save(produto);
		return produto;
	}
	
	@Override
	public void delete(String id) throws CustomException{
		if(productRepository.findById(id).isEmpty()) {
			throw new CustomException("Product not found!", HttpStatus.NOT_FOUND);
		}
		productRepository.deleteById(id);;
	}
	
}
