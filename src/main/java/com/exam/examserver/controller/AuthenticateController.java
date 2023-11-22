package com.exam.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.config.JwtUtils;
import com.exam.examserver.model.JwtRequest;
import com.exam.examserver.model.JwtResponse;
import com.exam.examserver.service.impl.UserDetailsServiceImpl;

@RestController
public class AuthenticateController  {
	
	
		@Autowired 
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private UserDetailsServiceImpl userDetailsService;
		
		@Autowired
		private JwtUtils jwtUtils;
		
		@PostMapping ("/generate-token")		
		public ResponseEntity<?> generateToken( @RequestBody JwtRequest jwtRequest) throws Exception{
			try {
				System.out.println("Inside generate token");
				authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			}
			catch(UsernameNotFoundException e) {
				e.printStackTrace();
				throw new Exception("User not found");
			}
			UserDetails  userDetails =this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
			String token = this.jwtUtils.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		}

		private void authenticate(String username, String password) throws Exception {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			}
			catch(DisabledException e) {
				throw new Exception("User Disabled"+ e.getMessage());
				
			}
			catch(BadCredentialsException e) {
				throw new Exception("Invalid Credentials"+ e.getMessage());
			}
			
		}
		
	}


