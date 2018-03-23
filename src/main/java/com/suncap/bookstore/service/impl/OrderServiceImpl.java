package com.suncap.bookstore.service.impl;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suncap.bookstore.repository.BillingAddressRepository;
import com.suncap.bookstore.repository.OrderRepository;
import com.suncap.bookstore.repository.PaymentRepository;
import com.suncap.bookstore.repository.ShippingAddressRepository;
import com.suncap.bookstore.security.domain.BillingAddress;
import com.suncap.bookstore.security.domain.Book;
import com.suncap.bookstore.security.domain.CartItem;
import com.suncap.bookstore.security.domain.Order;
import com.suncap.bookstore.security.domain.Payment;
import com.suncap.bookstore.security.domain.ShippingAddress;
import com.suncap.bookstore.security.domain.ShoppingCart;
import com.suncap.bookstore.security.domain.User;
import com.suncap.bookstore.service.BookService;
import com.suncap.bookstore.service.CartItemService;
import com.suncap.bookstore.service.OrderService;
import com.suncap.bookstore.utility.MailConstructor;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	public synchronized  Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
			){
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			Book book = cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber()-cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}

}


