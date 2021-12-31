package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("1")
public class Movie extends Item {
	
	@Column(name = "studio")
	private String studio;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "movie_rating")
	private MovieRating movieRating;
	
	public Movie() {
		
	}

	public Movie(String studio, MovieRating movieRating) {
		super();
		this.studio = studio;
		this.movieRating = movieRating;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public MovieRating getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(MovieRating movieRating) {
		this.movieRating = movieRating;
	}

	@Override
	public String toString() {
		return "Movie [studio=" + studio + ", movieRating=" + movieRating + "]";
	}
	
	

}
