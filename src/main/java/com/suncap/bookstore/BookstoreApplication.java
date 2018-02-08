package com.suncap.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.suncap.bookstore.security.config.SecurityUtility;
import com.suncap.bookstore.security.domain.Role;
import com.suncap.bookstore.security.domain.User;
import com.suncap.bookstore.security.domain.UserRole;
import com.suncap.bookstore.service.UserService;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		User user1 = new User();
		user1.setFirstname("John");
		user1.setLastname("Doe");
		user1.setUsername("john");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("john@emai.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstname("Admin");
		user2.setLastname("Admin");
		user2.setUsername("Admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("john@emai.com");
		Role role2 = new Role();
		role2.setId(1);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role1));
		
		userService.createUser(user2, userRoles);
	}
	
	
}
