package com.Movie.controller;

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
import com.Movie.entity.Movie;
import com.Movie.service.MovieServiceImpl;

@RestController
public class MovieController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;

	@GetMapping("/movie")
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> allMovies = movieServiceImpl.getAllMovies();
		System.out.println(allMovies);
		return new ResponseEntity<>(allMovies, HttpStatus.OK);
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable int id) {
		Movie movie = movieServiceImpl.getMovie(id);
		System.out.println(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@PutMapping("/movie")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		Movie status = movieServiceImpl.upsert(movie);
		System.out.println(status);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@PostMapping("/movie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		System.out.println(movie.getTitle());
		Movie status = movieServiceImpl.upsert(movie);
		System.out.println(status);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/movie/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable int id) {
		String status = movieServiceImpl.deleteMovie(id);
		System.out.println(status);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
