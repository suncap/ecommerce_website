package com.suncap.bookstore.service;

import com.suncap.bookstore.security.domain.UserShipping;

public interface UserShippingService {
	
	UserShipping findById(Long id);
	
	void removeById(Long id);

}
