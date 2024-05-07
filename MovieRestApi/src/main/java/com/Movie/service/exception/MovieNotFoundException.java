package com.Movie.service.exception;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFoundException() {
		super("Movie Is Not Available..");
	}

	public MovieNotFoundException(String msg) {
		super(msg);
	}

}
