package com.Movie.service;

import java.util.List;

import com.Movie.entity.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();

	public Movie getMovie(int id);

	public Movie upsert(Movie movie);

	public String deleteMovie(int id);

}
