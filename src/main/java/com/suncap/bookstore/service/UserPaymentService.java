package com.suncap.bookstore.service;

import com.suncap.bookstore.security.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	
	void removeById(Long id);
}
