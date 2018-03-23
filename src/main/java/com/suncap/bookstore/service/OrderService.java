package com.suncap.bookstore.service;

import com.suncap.bookstore.security.domain.BillingAddress;
import com.suncap.bookstore.security.domain.Order;
import com.suncap.bookstore.security.domain.Payment;
import com.suncap.bookstore.security.domain.ShippingAddress;
import com.suncap.bookstore.security.domain.ShoppingCart;
import com.suncap.bookstore.security.domain.User;

public interface OrderService {
	
	Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
	);

}

