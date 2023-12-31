package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configurable
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{


	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
			.authorizeRequests()
			.antMatchers("/public/**").hasAnyRole("NORMAL","ADMIN")
			.antMatchers("/user/**").hasRole("ADMIN")
			.antMatchers("/signin").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/dologin")
			.successHandler(customSuccessHandler);
		
			
			
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.userDetailsService(cusUserDServ).passwordEncoder(passwordEncoder());
		
		
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private AuthenticationSuccessHandler customSuccessHandler;
	
	@Autowired
	private UserDetailsService cusUserDServ;
	

	
	
	
	
	
	

}
