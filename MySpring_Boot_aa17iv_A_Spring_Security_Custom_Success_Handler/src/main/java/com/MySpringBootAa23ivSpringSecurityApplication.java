package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.models.User;
import com.repositories.UserRepository;

@SpringBootApplication
public class MySpringBootAa23ivSpringSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa23ivSpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setId(1);
		user.setEmail("user@gmail.com");
		user.setUsername("user");
		user.setPassword(passwordEncoder.encode("1234"));
		user.setRole("ROLE_NORMAL");
		userRepo.save(user);
		
		User user2 = new User();
		user2.setId(2);
		user2.setEmail("admin@gmail.com");
		user2.setUsername("admin");
		user2.setPassword(passwordEncoder.encode("1234"));
		user2.setRole("ROLE_ADMIN");
		userRepo.save(user2);
	}

}
