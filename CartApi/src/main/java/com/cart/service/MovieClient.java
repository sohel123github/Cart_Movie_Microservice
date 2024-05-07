package com.cart.service;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cart.entity.Movie;

@FeignClient(url = "http://localhost:8082", value = "MovieClient")
public interface MovieClient {

	@GetMapping("/movie/{cartId}")
	List<Movie> getMovieOfCart(@PathVariable int cartId);

}
