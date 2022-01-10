package com.skilldistillery.musicFestival.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

		return festivalRepo.getById(festivalId);
	}

	@Override
	public Festival update(Integer festivalId, Festival festival) {
		Festival fest = festivalRepo.getById(festivalId);
		fest = festivalRepo.saveAndFlush(festival);

		return fest;
	}

	@Override
	public Festival createFestival(@RequestBody Festival festival) {
		try {
			festivalRepo.save(festival);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid entry");
			festival = null;
		}
		return festival;
	}

	@Override
	public boolean deleteById(int festivalId) {
		boolean deleted = false;
		Festival festival = festivalRepo.getById(festivalId);
		if (festival != null) {
			festivalRepo.delete(festival);
			deleted = true;
		}
		return deleted;
	}

}
