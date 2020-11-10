package com.samuelTI.course.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.samuelTI.course.api.entities.Category;
import com.samuelTI.course.api.entities.OrderItem;
import com.samuelTI.course.api.entities.Orders;
import com.samuelTI.course.api.entities.Payment;
import com.samuelTI.course.api.entities.Product;
import com.samuelTI.course.api.entities.User;
import com.samuelTI.course.api.entities.enums.OrderStatus;
import com.samuelTI.course.api.repositories.CategoryRepository;
import com.samuelTI.course.api.repositories.OrderItemRepository;
import com.samuelTI.course.api.repositories.OrdersRepository;
import com.samuelTI.course.api.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99999999","123456");
		User u2 = new User(null, "Alex Green","alex@gmail.com","98989898","654321");
		
		Orders o1 = new Orders(null, Instant.parse("2020-06-20T20:59:07Z"),OrderStatus.PAID, u1);
		Orders o2 = new Orders(null, Instant.parse("2020-02-10T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u2);
		Orders o3 = new Orders(null, Instant.parse("2020-12-28T02:00:07Z"),OrderStatus.DELIVERED, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		ordersRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2020-06-20T21:59:07Z"), o1);
		
		o1.setPayment(pay1);
		
		ordersRepository.save(o1);
	}

}
