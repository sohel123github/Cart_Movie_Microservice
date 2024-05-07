package com.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.Movie.controller.MovieController;
import com.Movie.entity.Movie;
import com.Movie.service.MovieServiceImpl;

@SpringBootTest(classes = ControllerMockitoTest.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControllerMockitoTest {

	@Mock
	MovieServiceImpl movieServiceImpl;

	@InjectMocks
	MovieController movieController;

	@Test
	@Order(1)
	public void testGetAllMovies() {
		when(movieServiceImpl.getAllMovies()).thenReturn(Stream.of(new Movie(1, "Pink", 102),new Movie(2, "Dangal", 101)).collect(Collectors.toList()));
		ResponseEntity<List<Movie>> movieList = movieController.getAllMovies();
		List<Movie> movieData = movieList.getBody();
		assertEquals(2, movieData.size());
		}

	@Test
	@Order(2)
	public void testGetMovie() {
		int id = 101;
		Movie movieData = new Movie(101, "Dangal", 103);
		when(movieServiceImpl.getMovie(id)).thenReturn(movieData);
		ResponseEntity<Movie> movieSample = movieController.getMovie(id);
		Movie movieResult = movieSample.getBody();
		assertEquals(id, movieResult.getId());
	}

	@Test
	@Order(3)
	public void testUpdateMovie() {
		Movie movie = new Movie(101, "Dangal", 101);
		when(movieServiceImpl.upsert(movie)).thenReturn(movie);
		ResponseEntity<Movie> movieData = movieController.updateMovie(movie);
		Movie movieSample = movieData.getBody();
		assertEquals(movie, movieSample);
	}

	@Test
	@Order(4)
	public void testAddMovie() {
		Movie movieDemo = new Movie(1, "Jawan", 101);
		when(movieServiceImpl.upsert(movieDemo)).thenReturn(movieDemo);
		ResponseEntity<Movie> movieData = movieController.addMovie(movieDemo);
		Movie movieSample = movieData.getBody();
		assertEquals(movieDemo, movieSample);
	}

	@Test
	@Order(5)
	public void testDeleteMovie() {
		int id = 101;
		String sucMsg = "SUCCESS";
		when(movieServiceImpl.deleteMovie(id)).thenReturn(sucMsg);
		ResponseEntity<String> message = movieController.deleteMovie(id);
		String msg = message.getBody();
		assertEquals(sucMsg, msg);
	}

}
