package com.skilldistillery.musicFestival.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Festival> festivals() {
		return festivalService.getAllFestivals();
	}
	@GetMapping("festival/{festivalId}")
	public Festival festivalById(@PathVariable Integer festId, HttpServletResponse res) {
		Festival fest = festivalService.getFestivalById(festId);
				return fest;
	}
	@PutMapping("update/{festivalId}")
	public Festival updateFestival(@PathVariable Integer festivalId, @RequestBody Festival festival, HttpServletResponse res) {
		try {
			Festival fest = festivalService.update(festivalId, festival);
			if (festival == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			festival = null;
		}
		return festival;
	}
	
	@PostMapping("festivals")
	public Festival addFestival(@RequestBody Festival festival, HttpServletRequest hsrequest, HttpServletResponse hsres) {
		try {
			festivalService.createFestival(festival);
			hsres.setStatus(201);
			StringBuffer url = hsrequest.getRequestURL();
			url.append("/").append(festival.getId());
			hsres.setHeader("Testing", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Soemthing went wrong");
			hsres.setStatus(400);
			festival = null;
		}
		return festival;
	}
	
	@DeleteMapping("festivals/{festivalId}")
	public void deleteFestival(Integer festivalId, HttpServletResponse res) {
		try {
			if(festivalService.deleteById(festivalId)) {
				res.setStatus(204);
			}else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
}
