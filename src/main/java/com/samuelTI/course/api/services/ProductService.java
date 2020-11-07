package com.samuelTI.course.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelTI.course.api.entities.Product;
import com.samuelTI.course.api.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository userRepository;
	/**
	 * busca todos os Usuarios do banco de dados
	 * @return
	 */
	public List<Product> findAll(){
		return userRepository.findAll();
	}
	
	/**
	 * Busca todos os usuarios do banco pelo ID
	 */
	public Product findById(Long id) {
		Optional<Product> objetoProduct =  userRepository.findById(id);
		return objetoProduct.get();
	}
}
