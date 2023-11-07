package com.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
			.defaultSuccessUrl("/public/home");
		
			
			
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.inMemoryAuthentication().withUser("user").password("1234").roles("NORMAL");
	auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
	
		auth.inMemoryAuthentication().withUser("user").password(this.passwordEncoder().encode("1234")).roles("NORMAL");
		
		auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("1234")).roles("ADMIN");
		
		
		
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		
		return new BCryptPasswordEncoder();
	}
	
	
	
	

}
