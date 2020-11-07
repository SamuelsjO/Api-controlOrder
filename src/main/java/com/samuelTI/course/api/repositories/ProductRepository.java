package com.samuelTI.course.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelTI.course.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}

