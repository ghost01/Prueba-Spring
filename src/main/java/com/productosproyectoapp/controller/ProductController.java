package com.productosproyectoapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productosproyecto.app.entity.Product;
import com.productosproyecto.app.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	// Create a new product
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
		
	}
	
	//Read an product
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long productId) {
		Optional<Product> oProduct = productService.findById(productId);
		
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
			return ResponseEntity.ok(oProduct);
		
		}
	
	//Update an Product
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Product productDetails, @PathVariable(value = "id") Long productID) {
		Optional<Product> product = productService.findById(productID);
		
		if(!product.isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		
		//BeanUtils.copyProperties(productDetails, product.get());
		product.get().setProducto(productDetails.getProducto());
		product.get().setMarca(productDetails.getMarca());
		product.get().setValor(productDetails.getValor());
		product.get().setEnabled(productDetails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product.get()));
	}
	
	// Delete an Product
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id")Long productId) {
		if(!productService.findById(productId).isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		
		productService.deleteById(productId);
		return ResponseEntity.ok().build();
	}
	
	//Read all Users
	
	@GetMapping
	public List<Product> readAll() {
		
		List<Product> products = StreamSupport
				.stream(productService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	
		return products;
		
	}
		
	}