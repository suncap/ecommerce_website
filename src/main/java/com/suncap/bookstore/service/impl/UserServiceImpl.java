package com.suncap.bookstore.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suncap.bookstore.repository.RoleRepository;
import com.suncap.bookstore.repository.UserRepository;
import com.suncap.bookstore.security.domain.User;
import com.suncap.bookstore.security.domain.UserRole;
import com.suncap.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final static Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exists", user.getUsername());
		} else {
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
}
