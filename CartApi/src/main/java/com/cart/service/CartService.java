package com.cart.service;

import java.util.List;
import com.cart.entity.Cart;

public interface CartService {

	public List<Cart> getAllCart();
	
	public Cart getCart(int id);
	
	public String upsert(Cart cart);
	
	public String deleteCart(int id);
	
	
	
}
