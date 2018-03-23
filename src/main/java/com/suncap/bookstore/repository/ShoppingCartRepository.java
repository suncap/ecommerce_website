package com.suncap.bookstore.repository;
import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}


