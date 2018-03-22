package com.suncap.bookstore.service;

import java.util.Set;

import com.suncap.bookstore.security.domain.User;
import com.suncap.bookstore.security.domain.UserBilling;
import com.suncap.bookstore.security.domain.UserPayment;
import com.suncap.bookstore.security.domain.UserRole;
import com.suncap.bookstore.security.domain.UserShipping;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles);

	User findByUsername(String username);

	User findByEmail(String mail);

	User save(User user);

	User findById(Long id);

	void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setUserDefaultPayment(Long userPaymentId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultShipping(Long userShippingId, User user);

}
