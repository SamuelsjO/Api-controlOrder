package com.samuelTI.course.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelTI.course.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
