package com.samuelTI.course.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelTI.course.api.entities.Category;
import com.samuelTI.course.api.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository userRepository;
	/**
	 * busca todos os Usuarios do banco de dados
	 * @return
	 */
	public List<Category> findAll(){
		return userRepository.findAll();
	}
	
	/**
	 * Busca todos os usuarios do banco pelo ID
	 */
	public Category findById(Long id) {
		Optional<Category> objetoCategory =  userRepository.findById(id);
		return objetoCategory.get();
	}
}
