package com.samuelTI.course.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelTI.course.api.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

	
}

