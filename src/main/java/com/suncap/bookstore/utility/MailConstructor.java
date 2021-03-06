package com.suncap.bookstore.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;

import com.suncap.bookstore.security.domain.User;

public class MailConstructor {

	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructNewUserEmail(User user, String password) {
		String message = "\nPlease user the following credentials for" + user.getUsername()  + " " + password;
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("New user");
		email.setText(message);
		email.setFrom(env.getProperty("support.email"));
		
		return email;
	}
}
