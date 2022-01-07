package com.skilldistillery.musicFestival.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.musicFestival.entities.Festival;
import com.skilldistillery.musicFestival.services.FestivalService;

@RestController
@RequestMapping("api")
public class FestivalController {

	@Autowired
	private FestivalService festivalService;

	@GetMapping("festivals")
	public List<Festival> index() {
		return festivalService.getAllFestivals();
	}
}
