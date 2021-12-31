package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("3")
public class VideoGame extends Item {
	
	@Column(name = "console")
	private String console;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "game_rating")
	private GameRating gameRating;
	
	public VideoGame() {
		
	}

	public VideoGame(String console, GameRating gameRating) {
		super();
		this.console = console;
		this.gameRating = gameRating;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public GameRating getGameRating() {
		return gameRating;
	}

	public void setGameRating(GameRating gameRating) {
		this.gameRating = gameRating;
	}

	@Override
	public String toString() {
		return "VideoGame [console=" + console + ", gameRating=" + gameRating + "]";
	}
	
	

}
