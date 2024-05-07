package com.cart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cart.dao.CartRepository;
import com.cart.entity.Cart;
import com.cart.service.exception.CartNotFoundException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> getAllCart() {
		List<Cart> carts = cartRepository.findAll();
//		List<Cart> newCartList = carts.stream().map(cart -> {
//			cart.setMovie(movieClient.getMovieOfCart(cart.getId()));
//			return cart;
//		}).collect(Collectors.toList());
		return carts;
	}

	@Override
	public Cart getCart(int id) {
		Cart cart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException("Cart Not Found !"));
//		cart.setMovie(movieClient.getMovieOfCart(cart.getId()));
		return cart;
	}

	@Override
	public String upsert(Cart cart) {
		cartRepository.save(cart);
		return "Success";
	}

	@Override
	public String deleteCart(int id) {
		cartRepository.deleteById(id);
		return "deleted Successfully..";
	}

}
