package com.skilldistillery.musicFestival.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.musicFestival.entities.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Integer> {

}
