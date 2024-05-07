package com.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.Movie.dao.MovieRepository;
import com.Movie.service.MovieServiceImpl;
import com.Movie.entity.Movie;

@SpringBootTest(classes = ServiceMockitoTest.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceMockitoTest {

	@Mock
	MovieRepository movieRepository;

	@InjectMocks
	MovieServiceImpl movieServiceImpl;

	@Test
	@Order(1)
	public void testGetAllMovies() {
		when(movieRepository.findAll()).thenReturn(Stream.of(new Movie(1, "Dangal", 101),new Movie(2, "Jawan", 102)).collect(Collectors.toList()));
		List<Movie> actualData = movieServiceImpl.getAllMovies();
		assertEquals(2, actualData.size());		
	}

	@Test
	@Order(2)
	public void testGetMovie() {
		int id = 11;
		Movie mV = new Movie(11, "Pathan", 101);
		when(movieRepository.findById(id)).thenReturn(Optional.of(mV));
		Movie m = movieServiceImpl.getMovie(id);
		assertEquals(id, m.getId());
	}

	@Test
	@Order(3)
	public void testUpsert() {
		Movie movieDemo = new Movie(1001, "Race", 102);
		when(movieRepository.save(movieDemo)).thenReturn(movieDemo);
		Movie movieSample = movieServiceImpl.upsert(movieDemo);
		assertEquals(movieDemo, movieSample);
	}

	@Test
	@Order(4)
	public void testDeleteMovie() {
		int id = 501;
		doNothing().when(movieRepository).deleteById(id);
		movieServiceImpl.deleteMovie(id);
		verify(movieRepository, times(1)).deleteById(id);
	}

}
