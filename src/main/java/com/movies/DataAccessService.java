package com.movies;

import java.util.List;

public interface DataAccessService {

	List<MovieDto> search(RequestDto requestDto);
	
	MovieDto getOne(RequestDto requestDto);
	
	void create(MovieDto movieDto);
	
	void delete(RequestDto requestDto);

	void update(MovieDto movieDto);

}
