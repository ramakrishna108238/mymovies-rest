package com.movies;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies_Collection")
public class MovieDto {

	@Indexed
	private String name;
	private String director;
	private String cast;
	private Double averageRating;
	private String genre;
	private String year;
	private List<RatingDto> ratingList;

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

	public List<RatingDto> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<RatingDto> ratingList) {
		this.ratingList = ratingList;
	}

}
