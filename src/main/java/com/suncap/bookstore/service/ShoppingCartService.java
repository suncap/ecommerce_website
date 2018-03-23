package com.suncap.bookstore.service;

import com.suncap.bookstore.security.domain.ShoppingCart;

public interface ShoppingCartService {
	
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	
	void clearShoppingCart(ShoppingCart shoppingCart);

}
