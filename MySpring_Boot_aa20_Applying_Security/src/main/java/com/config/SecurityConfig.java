package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity 
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public static PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
//		http.csrf().disable()
//			.authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll()
//			).httpBasic(Customizer.withDefaults());
//		
//		return http.build();
		
	http
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/adminhome")
		.hasRole("ADMIN")
		.requestMatchers("/userhome") // for multiple url's use("/home/normal/**")
		.hasRole("USER")
		.requestMatchers("/about","/") // it is accessible by all
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.and()
		.formLogin();
		
		
		
		return http.build();

	}
	
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails admin = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		UserDetails user  = User
				.withUsername("swapnil")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
				
		
	
		
	}
	
}
