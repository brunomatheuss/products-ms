package com.bruno.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.demo.entity.Product;
import com.bruno.demo.service.ProductService;

@RestController
@RequestMapping("v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/{id}")
	Object findById(@PathVariable("id") String id){
		return productService.findById(id);
	}
		
	@GetMapping()
	List<Product> findAll(){
		return productService.findAll();
	}
	
	@PostMapping("/product")
	Product save(@Valid @RequestBody Product produto){
		return productService.save(produto);
	}
	
	@PutMapping("/product/{id}")
	void update(@PathVariable("id") String id, @Valid @RequestBody Product produto){
		productService.update(id, produto);
	}
	
}
