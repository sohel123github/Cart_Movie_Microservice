package com.Movie.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Movie.dao.MovieRepository;
import com.Movie.entity.Movie;
import com.Movie.service.exception.MovieNotFoundException;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> listOfMovie = movieRepository.findAll();
		System.out.println(listOfMovie);
		return listOfMovie;
	}

	@Override
	public Movie getMovie(int id) {
		Movie findById = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException());
		System.out.println(findById);
		return findById;
	}

	@Override
	public Movie upsert(Movie movie) {
		Movie movieObj = movieRepository.save(movie);
		System.out.println(movieObj);
		return movieObj;
	}

	@Override
	public String deleteMovie(int id) {
		movieRepository.deleteById(id);
		System.out.println(id);
		return "deleted successfully..";
	}

}
