package com.samuelTI.course.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelTI.course.api.entities.Orders;
import com.samuelTI.course.api.repositories.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository OrdersRepository;
	/**
	 * busca todos os Usuarios do banco de dados
	 * @return
	 */
	public List<Orders> findAll(){
		return OrdersRepository.findAll();
	}
	
	/**
	 * Busca todos os usuarios do banco pelo ID
	 */
	public Orders findById(Long id) {
		Optional<Orders> objetoOrders =  OrdersRepository.findById(id);
		return objetoOrders.get();
	}
}
