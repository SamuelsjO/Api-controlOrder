package com.samuelTI.course.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.samuelTI.course.api.entities.User;
import com.samuelTI.course.api.repositories.UserRepository;
import com.samuelTI.course.api.services.exceptions.DatabaseExecption;
import com.samuelTI.course.api.services.exceptions.ResourcesNotFoundException;

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
		return objetoUser.orElseThrow(() -> new ResourcesNotFoundException(id));
	}
	
    /**
     * Insere um Usuario no banco
     */
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	/**
	 * deleta um usuario
	 */
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourcesNotFoundException(id);
		} catch (DataIntegrityViolationException ex ) {
			throw new DatabaseExecption(ex.getMessage());
		}
		
	}
	
	/**
	 * Atualizar usuario
	 */
	public User update(Long id, User obj) {
		try {
			User entity = userRepository.getOne(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourcesNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
	
}
