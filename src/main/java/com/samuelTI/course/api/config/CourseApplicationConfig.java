package com.samuelTI.course.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.samuelTI.course.api.entities.Category;
import com.samuelTI.course.api.entities.Orders;
import com.samuelTI.course.api.entities.User;
import com.samuelTI.course.api.entities.enums.OrderStatus;
import com.samuelTI.course.api.repositories.CategoryRepository;
import com.samuelTI.course.api.repositories.OrdersRepository;
import com.samuelTI.course.api.repositories.UserRepository;

@Configuration
//Rodar perfil de teste com base no Application-test.properties
@Profile("test")
public class CourseApplicationConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99999999","123456");
		User u2 = new User(null, "Alex Green","alex@gmail.com","98989898","654321");
		
		Orders o1 = new Orders(null, Instant.parse("2020-06-20T20:59:07Z"),OrderStatus.PAID, u1);
		Orders o2 = new Orders(null, Instant.parse("2020-02-10T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u2);
		Orders o3 = new Orders(null, Instant.parse("2020-12-28T02:00:07Z"),OrderStatus.DELIVERED, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		ordersRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}

}
