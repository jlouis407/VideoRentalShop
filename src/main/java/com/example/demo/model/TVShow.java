package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("2")
public class TVShow extends Item {
	
	@Column(name = "channel")
	private String channel;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tv_show_rating")
	private TVShowRating tvShowRating;
	
	public TVShow() {
		
	}

	public TVShow(String channel, TVShowRating tvShowRating) {
		super();
		this.channel = channel;
		this.tvShowRating = tvShowRating;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public TVShowRating getTvShowRating() {
		return tvShowRating;
	}

	public void setTvShowRating(TVShowRating tvShowRating) {
		this.tvShowRating = tvShowRating;
	}

	@Override
	public String toString() {
		return "TVShow [channel=" + channel + ", tvShowRating=" + tvShowRating + "]";
	}
	
	

}
