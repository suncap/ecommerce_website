package com.suncap.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.CartItem;
import com.suncap.bookstore.security.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
}

