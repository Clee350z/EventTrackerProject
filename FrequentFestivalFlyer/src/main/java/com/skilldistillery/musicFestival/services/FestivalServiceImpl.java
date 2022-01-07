package com.skilldistillery.musicFestival.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.musicFestival.entities.Festival;
import com.skilldistillery.musicFestival.repositories.FestivalRepository;

@Service
public class FestivalServiceImpl implements FestivalService {

	@Autowired
	private FestivalRepository festivalRepo;
	@Override
	public List<Festival> getAllFestivals() {
		return festivalRepo.findAll();
	}

	@Override
	public Festival getFestivalById(int festivalId) {
		
		return null;
	}

}
