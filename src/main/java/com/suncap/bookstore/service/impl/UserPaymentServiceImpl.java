package com.suncap.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suncap.bookstore.repository.UserPaymentRepository;
import com.suncap.bookstore.security.domain.UserPayment;

@Service
public class UserPaymentServiceImpl {
	
	@Autowired
	private UserPaymentRepository userPaymentRepository;

	public UserPayment findById(Long id) {
		return userPaymentRepository.findOne(id);
	}

	public void removeById(Long id) {
		userPaymentRepository.delete(id);
	}

}
