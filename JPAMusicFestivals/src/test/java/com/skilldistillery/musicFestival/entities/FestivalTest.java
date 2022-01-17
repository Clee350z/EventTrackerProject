package com.skilldistillery.musicFestival.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FestivalTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Festival festival;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAMusicFestivals");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		festival = em.find(Festival.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		festival = null;
	}

	@Test
	void test_Festival_mapping() {
		assertNotNull(festival);
		assertEquals("Global Dance", festival.getName());

	}
	


}
