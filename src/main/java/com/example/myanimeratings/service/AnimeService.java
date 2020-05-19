package com.example.myanimeratings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myanimeratings.anime.Anime;
import com.example.myanimeratings.repository.AnimeRepository;

@Service
public class AnimeService {

	@Autowired
	private AnimeRepository animeRepository;
	
	// create
	public Anime createAnime(String name, float rating) {
		return animeRepository.save(new Anime(name, rating));
	}
	
	// get all
	public List<Anime> getAll() {
		return animeRepository.findAll();
	}

	// get all animes with same rating
	public List<Anime> getByRating(float rating) {
		return animeRepository.findByRating(rating);
	}
	
	// update
	public Anime update(String name, float rating) {
		Anime a = animeRepository.findByName(name);
		a.setRating(rating);
		return animeRepository.save(a);
	}
	
	// delete by name
	public void deleteByName(String name) {
		Anime a = animeRepository.findByName(name);
		animeRepository.delete(a);
	}
	
	// delete all
	public void deleteAll() {
		animeRepository.deleteAll();
	}
}
