package com.exam.examserver;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.service.UserService;

@SpringBootApplication
@EnableJpaRepositories
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args)   {
		SpringApplication.run(ExamserverApplication.class, args);
	}
	@Override
	public void run(String...args) throws Exception{
		System.out.println("starting the code");
//		User user =new User();
//		user.setFirstName("Vinku");
//		user.setLastName("Shukla");
//		user.setUsername("Vinayak");
//		user.setPassword(this.bCryptPasswordEncoder.encode("Vinayak"));
//		user.setEmail("vinku@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1= new Role();
//		role1.setRoleId(33L);
//		role1.setRoleName("ADMIN");
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole= new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
		
	}

}
