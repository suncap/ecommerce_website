package com.suncap.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suncap.bookstore.repository.UserShippingRepository;
import com.suncap.bookstore.security.domain.UserShipping;
import com.suncap.bookstore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		userShippingRepository.delete(id);
	}
}


