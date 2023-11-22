package com.exam.examserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class MySecurityConfig   {
	
	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		// TODO Auto-generated method stub
		return  builder.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncode() {
		return NoOpPasswordEncoder.getInstance();
	}

}
