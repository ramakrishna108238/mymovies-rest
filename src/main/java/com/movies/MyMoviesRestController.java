package com.movies;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movies")
public class MyMoviesRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MyMoviesRestController.class);
	
	@Autowired
	DataAccessService dataAccessService;
	
	//Create a movie
	@RequestMapping(method = RequestMethod.POST)
	private String createMovie(@RequestBody final MovieDto movieDto) {
		LOG.info("Got the create request :: "+movieDto.getName());
		dataAccessService.create(movieDto);
		return movieDto.getName() + " created";
	}

	//Get a movie
	@RequestMapping(method = RequestMethod.GET)
	private List<MovieDto> getMovie(@RequestParam MultiValueMap<String, String> requestParams) {
		//transform requestParams to requestDto
		return dataAccessService.search(RequestUtils.getRequest(requestParams));
	}
	
	//Update a movie
	@RequestMapping(method = RequestMethod.PUT)
	private String updateMovie(@RequestBody final MovieDto movieDto) {
		LOG.info("Got the create request :: "+movieDto.getName());
		dataAccessService.update(movieDto);
		return movieDto.getName() + " updated";
	}
	
	//Delete a movie
	@RequestMapping(method = RequestMethod.DELETE)
	private void deleteMovie(@RequestParam MultiValueMap<String, String> requestParams) {
		//transform requestParams to requestDto
		dataAccessService.delete(RequestUtils.getRequest(requestParams));
	}
	
}
