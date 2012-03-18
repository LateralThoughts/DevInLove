package com.lateralthoughts.devinlove.framework;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/applicationContext.xml")
@Transactional
public class GraphPopulatorTest {

	@Autowired
	GraphPopulator populator;

	@Test
	public void when_loading_data_then_everythings_OK/* :) */() {
		assertThat(populator).isNotNull();
		populator.loadData();
	}
}
