package com.bruno.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.demo.dto.ProductDTO;
import com.bruno.demo.entity.Product;
import com.bruno.demo.exception.CustomException;
import com.bruno.demo.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") String id) throws CustomException{
		return productService.findById(id);
	}
		
	@GetMapping()
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/search")
	public List<ProductDTO.Response.Search> search(@RequestParam(required = false) String q, @RequestParam(required = false) Double min_price, 
			@RequestParam(required = false) Double max_price) throws CustomException{
		return productService.search(q, min_price, max_price);
	}
	@PostMapping()
	public ResponseEntity<Product> save(@Valid @RequestBody Product produto){
		return productService.save(produto);
	}
	
	@PutMapping("{id}")
	public Product update(@PathVariable("id") String id, @Valid @RequestBody Product produto) throws CustomException{
		return productService.update(id, produto);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) throws CustomException{
		productService.delete(id);
	}
	
}
