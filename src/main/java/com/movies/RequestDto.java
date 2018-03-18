package com.movies;

import java.util.Map;

public class RequestDto {
	
	private String name;
	private String director;
	private String cast;
	private Double averageRating;
	private String genre;
	private String year;
	
	private String ratingSite;
	private String ratingSiteRating;

	private String searchIndicator;
	
	private Map<String, String> requestParamMap;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRatingSite() {
		return ratingSite;
	}

	public void setRatingSite(String ratingSite) {
		this.ratingSite = ratingSite;
	}

	public String getRatingSiteRating() {
		return ratingSiteRating;
	}

	public void setRatingSiteRating(String ratingSiteRating) {
		this.ratingSiteRating = ratingSiteRating;
	}

	public String getSearchIndicator() {
		return searchIndicator;
	}

	public void setSearchIndicator(String searchIndicator) {
		this.searchIndicator = searchIndicator;
	}

	public Map<String, String> getRequestParamMap() {
		return requestParamMap;
	}

	public void setRequestParamMap(Map<String, String> requestParamMap) {
		this.requestParamMap = requestParamMap;
	}

	
}
