package com.anderson.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anderson.project.entities.Category;
import com.anderson.project.entities.Order;
import com.anderson.project.entities.User;
import com.anderson.project.entities.enums.OrderStatus;
import com.anderson.project.repositories.CategoryRepository;
import com.anderson.project.repositories.OrderRepository;
import com.anderson.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Carla", "carla@email.com", "11223344", "pass1234");
		User user2 = new User(null, "Pedro", "pedro@email.com", "99887766", "user1234");

		Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);
		
		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
	}
}
