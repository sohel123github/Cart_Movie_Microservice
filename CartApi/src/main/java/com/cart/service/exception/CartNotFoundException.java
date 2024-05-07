package com.cart.service.exception;

public class CartNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CartNotFoundException() {
		super("Cart not available with such ID..");
	}

	public CartNotFoundException(String msg) {
		super(msg);
	}

}
