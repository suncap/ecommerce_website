package com.suncap.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
	
}
