package com.suncap.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
