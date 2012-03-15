package com.lateralthoughts.devinlove.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/applicationContext.xml")
public class MascotRepositoryTest {

	@Autowired
	MascotRepository mascotRepository;

	@Test
	public void when_loading_context_then_mascot_repository_can_be_retrieved() {
		assertThat(mascotRepository).isNotNull();
	}
}
