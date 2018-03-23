package com.suncap.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.BookToItemCart;
import com.suncap.bookstore.security.domain.CartItem;

public interface BookToCartItemRepository extends CrudRepository<BookToItemCart, Long> {
	void deleteByCartItem(CartItem cartItem);
}
