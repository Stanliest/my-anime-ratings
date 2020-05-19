package com.example.myanimeratings.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myanimeratings.anime.Anime;

public interface AnimeRepository extends MongoRepository<Anime, String> {
	public Anime findByName(String name);
	public List<Anime> findByRating(float rating);
	// the floaterface implements the above methods autometically
}
