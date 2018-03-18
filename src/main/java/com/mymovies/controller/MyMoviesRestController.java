/*package com.mymovies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movies")
public class MyMoviesRestController {
	
	//Create a movie
	@RequestMapping(method = RequestMethod.POST)
	private String createMovie() {
		//Call database and add the movie
		return "Titanic created";
	}

	//Get a movie
	@RequestMapping(method = RequestMethod.GET)
	private String getMovie() {
		//Call database and get the movie
		return "Titanic retrieved";
	}
	
	//Update a movie
	@RequestMapping(method = RequestMethod.PUT)
	private String updateMovie() {
		//Call database and update the movie
		return "Titanic updated";
	}
	
	//Delete a movie
	@RequestMapping(method = RequestMethod.DELETE)
	private String deleteMovie() {
		//Call database and add the movie
		return "Titanic deleted";
	}
	
}
*/