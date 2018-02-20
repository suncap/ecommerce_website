package com.suncap.bookstore.service;

import java.util.Set;

import com.suncap.bookstore.security.domain.User;
import com.suncap.bookstore.security.domain.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles);
	User findByUsername(String username);
	User findByEmail(String mail);
	User save(User user);
	User findById(Long id);
}
