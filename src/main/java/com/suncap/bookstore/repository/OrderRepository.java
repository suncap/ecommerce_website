package com.suncap.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.Order;
import com.suncap.bookstore.security.domain.User;

public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findByUser(User user);
}



