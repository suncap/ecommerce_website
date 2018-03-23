package com.suncap.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.BillingAddress;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long>{

}
