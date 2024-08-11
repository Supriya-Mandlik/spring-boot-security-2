package com.code.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//custom security configuration
//here we have generated our own custom security filter

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.sessionManagement(session
				-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//http.formLogin();
		http.httpBasic();
		return http.build();
	}
	
	//in basic authentication we get the alert box at browser and in this we don't have logout functionality.
	//inform based authentication we get form for authentication and we can use logout functionality for logout
	//SessionCreationPolicy.STATELESS is to make our api stateless
}
