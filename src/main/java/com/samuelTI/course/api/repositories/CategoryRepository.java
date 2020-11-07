package com.samuelTI.course.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelTI.course.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}

