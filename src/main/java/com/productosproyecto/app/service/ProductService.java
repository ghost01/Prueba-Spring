package com.productosproyecto.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.productosproyecto.app.entity.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Optional<Product> findById(Long id);
	
	public Product save(Product product);
	
	public void deleteById(Long id);
	
	public List<Product> findALL();
	
	public void listByProduct (Long id);
}