package com.lateralthoughts.devinlove.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class CategoryTest {

	@Test
	public void when_instanciating_with_name_then_retrieved() {
		Category category = new Category();
		category.setName("build");
		assertThat(category.getName()).isEqualTo("build");
	}
}
