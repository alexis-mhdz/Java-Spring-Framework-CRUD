package com.indra.crud;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.indra.crud.model.UserEntity;

@SpringBootTest
class CrudApplicationTests {

	/*
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	
	@Test
	void contextLoads() {
		/*
		UserEntity user = new UserEntity();
		user.setUsername("Alexis");
		user.setPassword(bCryptPasswordEncoder.encode("12345"));
		user.setEnabled(true);
		
		UserEntity returnUser = userRepository.save(user);
		assertTrue(returnUser.getPassword().equalsIgnoreCase(user.getPassword()));
		*/
	}

}
