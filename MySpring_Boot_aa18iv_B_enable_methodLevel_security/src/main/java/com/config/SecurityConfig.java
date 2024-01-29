package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
@EnableMethodSecurity 
Determines if Spring Security's PreAuthorize, PostAuthorize,
PreFilter and PostFilter annotations should be enabled. 
Default is true.
Returns: true if pre/post annotations should be
enabled false otherwise

*/
@Configuration
@EnableMethodSecurity 
public class SecurityConfig {

	@Bean
	public static PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
			.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated()
			).httpBasic(Customizer.withDefaults());
		
		return http.build();

	}
	
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		UserDetails swapnil  = User.builder()
				.username("swapnil")
				.password(passwordEncoder().encode("swapnil"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,swapnil);
				
		
		// Now you can remove the username and password
		// which you have mention in application.properties
		
	}
	
}
