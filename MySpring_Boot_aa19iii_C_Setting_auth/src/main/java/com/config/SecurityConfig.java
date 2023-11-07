package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails normalUser = User
									.withUsername("swapnil")
									.password(passwordEncoder().encode("swapnil"))
									.roles("NORMAL")
									.build();
		
		UserDetails adminUser = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(normalUser,adminUser);
	
									
	}
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/home/admin")
		.hasRole("ADMIN")
		.requestMatchers("/home/normal") // for multiple url's use("/home/normal/**")
		.hasRole("NORMAL")
		.requestMatchers("/home/public") // it is accessible by all
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
