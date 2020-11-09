package com.samuelTI.course.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelTI.course.api.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
