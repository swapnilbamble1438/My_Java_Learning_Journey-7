package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@SuppressWarnings("deprecation")
	@Bean
	 PasswordEncoder  passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailService);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers("/home/admin")
//		.hasRole("ADMIN")
//		.requestMatchers("/home/normal") // for multiple url's use("/home/normal/**")
//		.hasRole("NORMAL")
		.requestMatchers("/home/public") // it is accessible by all
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
