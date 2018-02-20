package com.suncap.bookstore.resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suncap.bookstore.security.config.SecurityUtility;
import com.suncap.bookstore.security.domain.Role;
import com.suncap.bookstore.security.domain.User;
import com.suncap.bookstore.security.domain.UserRole;
import com.suncap.bookstore.service.UserService;
import com.suncap.bookstore.utility.MailConstructor;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/newUser", method=RequestMethod.GET)
	public ResponseEntity newUserPost(HttpServletRequest request, @RequestBody HashMap<String,String> mapper) throws Exception{
		String userName = mapper.get("username");
		String userEmail = mapper.get("email");
		
		if(userService.findByUsername(userName) != null) {
			return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
		}
		
		if(userService.findByEmail(userEmail) != null) {
			return new ResponseEntity("useremailExists", HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setUsername(userName);
		user.setEmail(userEmail);
		String password = SecurityUtility.randomPassword();
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		
		Role role = new Role();
		role.setId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user,role));
		userService.createUser(user, userRoles);
		
		SimpleMailMessage email = mailConstructor.constructNewUserEmail(user,password);
		mailSender.send(email);
		
		return new ResponseEntity("user addess succesfulluy", HttpStatus.OK);
	}
}
