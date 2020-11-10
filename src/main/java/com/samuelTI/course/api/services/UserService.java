package com.samuelTI.course.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelTI.course.api.entities.User;
import com.samuelTI.course.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	/**
	 * busca todos os Usuarios do banco de dados
	 * @return
	 */
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/**
	 * Busca todos os usuarios do banco pelo ID
	 */
	public User findById(Long id) {
		Optional<User> objetoUser =  userRepository.findById(id);
		return objetoUser.get();
	}
	
    /**
     * Insere um Usuario no banco
     */
	public User insert(User obj) {
		return userRepository.save(obj);
	}
}
