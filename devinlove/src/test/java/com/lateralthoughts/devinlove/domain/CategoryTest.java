package com.lateralthoughts.devinlove.domain;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.lateralthoughts.devinlove.domain.Category;


public class CategoryTest {

	@Test
	public void when_instanciating_with_name_then_retrieved() {
		Category category = new Category("build");
		Assertions.assertThat(category.getName()).isEqualTo("build");
	}
}
