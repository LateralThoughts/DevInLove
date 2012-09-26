package com.lateralthoughts.devinlove.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lateralthoughts.devinlove.domain.Mascot;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:devinlove-core.xml")
@Transactional
public class MascotRepositoryTest {

	@Autowired
	private MascotRepository mascotRepository;
	private Mascot mascot;

	@Before
	public void setup() {
		mascot = new Mascot();
		mascot.setName("Tux");
	}

	@Test
	public void when_inserting_then_retrievable() {
		assertThat(mascotRepository).isNotNull();
        mascotRepository.save(mascot);
		assertThat(mascot.getId()).isGreaterThan(0L);
	}
}
