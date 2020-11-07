package com.samuelTI.course.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.samuelTI.course.api.entities.User;
import com.samuelTI.course.api.repositories.UserRepository;

@Configuration
//Rodar perfil de teste com base no Application-test.properties
@Profile("test")
public class CourseApplicationConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99999999","123456");
		User u2 = new User(null, "Alex Green","alex@gmail.com","98989898","654321");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

}
