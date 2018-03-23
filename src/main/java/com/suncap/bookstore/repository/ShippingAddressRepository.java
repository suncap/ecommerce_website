package com.suncap.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
	
}
