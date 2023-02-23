package com.anderson.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anderson.project.entities.User;
import com.anderson.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Carla", "carla@email.com", "11223344", "pass1234");
		User user2 = new User(null, "Pedro", "pedro@email.com", "99887766", "user1234");

		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
