package com.cart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cart.entity.Cart;
import com.cart.service.CartServiceImpl;

@RestController
public class CartController {

	@Autowired
	private CartServiceImpl cartServiceImpl;

//	@Autowired
//	private RestTemplate restTemplate;

	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getAllCart() {
//		restTemplate.getForObject("http://localhost:8082/movie/cartId/"+cart.cartId(), null)
		List<Cart> list = cartServiceImpl.getAllCart();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable int id) {
		Cart cart = cartServiceImpl.getCart(id);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@PutMapping("/cart")
	public ResponseEntity<String> updateCart(@RequestBody Cart cart) {
		String status = cartServiceImpl.upsert(cart);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@PostMapping("/cart")
	public ResponseEntity<String> addCart(@RequestBody Cart cart) {
		String status = cartServiceImpl.upsert(cart);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/cart/{id}")
	public ResponseEntity<String> deleteCart(@PathVariable int id) {
		String status = cartServiceImpl.deleteCart(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/")
	public String Hello() {
		return "This is an Cart Api..";
	}

}
