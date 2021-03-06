package com.skilldistillery.musicFestival.services;

import java.util.List;

import com.skilldistillery.musicFestival.entities.Festival;

public interface FestivalService {
	List<Festival> getAllFestivals();

	Festival getFestivalById(int festivalId);

	Festival update(Integer festivalId, Festival festival);
	
	Festival createFestival(Festival festival);
	
	boolean deleteById(int festivalId);

	Festival getFestivalByName(String festivalName);
}
