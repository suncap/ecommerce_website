package com.suncap.bookstore.service;

import java.util.List;

import com.suncap.bookstore.security.domain.Book;
import com.suncap.bookstore.security.domain.CartItem;
import com.suncap.bookstore.security.domain.ShoppingCart;
import com.suncap.bookstore.security.domain.User;

public interface CartItemService {
	
	CartItem addBookToCartItem(Book book, User user, int qty);
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
	
	CartItem updateCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem findById(Long id);
	
	CartItem save(CartItem cartItem);

}


