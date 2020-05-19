package com.example.myanimeratings.anime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Anime {
	@Id
	String id;
	String name;
	float rating;
	
	public Anime(String name, float rating) {
		this.name = name;
		this.rating = rating;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return "Anime: "+name+" rating: "+rating;
	}
}
