package com.suncap.bookstore.security.domain;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -12635161693001549L;
	private String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}

}
