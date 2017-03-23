package it.alfonso.movieblog.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.alfonso.movieblog.beans.Movie;

@RestController
public class MovieController {

	@RequestMapping(value="/movies", method=RequestMethod.GET, headers="Accept=application/json")
	public List<Movie> getMovies() {
		return createMovieList();
	}
	
	@RequestMapping(value="/movies/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public Movie getMovieById(@PathVariable int id) {
		for(Movie movie : createMovieList()) {
			if(movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}
	
	private List<Movie> createMovieList() {
		Movie movie1 = new Movie(1, "The Wolf of Wall Street", "Martin Scorsese", "2013");
		Movie movie2 = new Movie(2, "Birdman", "Alejandro Gonzales Inarritu", "2014");
		Movie movie3 = new Movie(3, "La La Land", "Damien Chazelle", "2016");
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		
		return movies;
	}
	
}
