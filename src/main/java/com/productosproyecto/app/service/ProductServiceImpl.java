package com.productosproyecto.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productosproyecto.app.entity.Product;
import com.productosproyecto.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

		@Autowired
		private ProductRepository productRepository;

		@Override
		@Transactional(readOnly = true)
		public Iterable<Product> findAll() {
			return productRepository.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Page<Product> findAll(Pageable pageable) {
			return productRepository.findAll(pageable);
		}

		@Override
		@Transactional(readOnly = true)
		public Optional<Product> findById(Long id) {
			return productRepository.findById(id);
		}

		@Override
		@Transactional
		public Product save(Product product) {
			return productRepository.save(product);
		}

		@Override
		@Transactional
		public void deleteById(Long id) {
			productRepository.deleteById(id);
		}

		@Override
		public List<Product> findALL() {
			return null;
		}

		@Override
		public void listByProduct(Long id) {
	// TODO Auto-generated method stub
	
}

}