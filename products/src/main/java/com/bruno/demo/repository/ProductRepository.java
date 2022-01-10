package com.bruno.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bruno.demo.dto.ProductDTO;
import com.bruno.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("select p.id as id, p.name as name, p.description as description, p.price as price "
			+ "from Product p "
			+ "where ((?1 is null or p.name = ?1) or (?1 is null or p.description = ?1)) "
			+ "and (?2 is null or p.price >= ?2) and (?3 is null or p.price <= ?3)")
	List<ProductDTO.Response.Search> search(String q, Double min_price, Double max_price);
	
}
