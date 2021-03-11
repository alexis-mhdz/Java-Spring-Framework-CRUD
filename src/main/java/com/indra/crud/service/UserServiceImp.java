package com.indra.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.User;
import com.indra.crud.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String insertUser(User user) {
		try {
			userRepository.save(user);
			return "Usuario agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el usuario";
		}
	}

	@Override
	public List<User> searchAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User searchUser(User user) {
		Optional<User> objetoRegreso = userRepository.findById(user.getUsername()); 
		
		if(objetoRegreso.isPresent()) {
			user = objetoRegreso.get();
		}
		
		return user;
	}

	@Override
	public Boolean updateUser(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Boolean deleteUser(User user) {
		try {
			userRepository.deleteById(user.getUsername());			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
