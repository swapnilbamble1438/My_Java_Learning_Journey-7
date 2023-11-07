package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.Role;
import com.repository.RoleRepository;

@SpringBootApplication
public class MySpringBootAa26iiiRoleBaseAuthorizationApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa26iiiRoleBaseAuthorizationApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("USER");
		roleRepo.save(role1);
		
		Role role2 = new Role();
		role2.setId(2);
		role2.setName("CREATOR");
		roleRepo.save(role2);
		
		Role role3 = new Role();
		role3.setId(3);
		role3.setName("EDITOR");
		roleRepo.save(role3);
		
		Role role4 = new Role();
		role4.setId(4);
		role4.setName("ADMIN");
		roleRepo.save(role4);
		
		
		
	}

}
