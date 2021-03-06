package com.example.myanimeratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myanimeratings.anime.Anime;
import com.example.myanimeratings.service.AnimeService;

@RestController
public class AnimeController {

	@Autowired
	private AnimeService animeService;

	@PostMapping("/create")
	public String createAnime(@RequestParam String name, @RequestParam float rating) {
		Anime a = animeService.createAnime(name, rating);
		return a.toString();
		// use @RequestParam if we want to pass params in the endpoint
		// use @RequestBody if we want to pass a json as body
	}

	@RequestMapping("/getAll")
	public List<Anime> getAllAnime() {
		return animeService.getAll();
	}
	
	@RequestMapping("/getAnimeByRating")
	public List<Anime> getAnimeByRating(@RequestParam float rating) {
		return animeService.getByRating(rating);
	}
	
	@PutMapping("/updateAnime")
	public String updateAnime(@RequestParam String name, @RequestParam float rating) {
		Anime a = animeService.update(name, rating);
		return a.toString();
	}	
	
	@DeleteMapping("/deleteAnime")
	public String deleteAnime(@RequestParam String name) {
		animeService.deleteByName(name);
		return "Deleted " + name;
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		animeService.deleteAll();
		return "Deleted all anime ratings";
	}
	
}
