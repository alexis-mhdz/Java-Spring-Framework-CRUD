package com.indra.crud;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


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
