package com.suncap.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.UserBilling;

public interface UserBillingRepository extends CrudRepository<UserBilling, Long> {

}
