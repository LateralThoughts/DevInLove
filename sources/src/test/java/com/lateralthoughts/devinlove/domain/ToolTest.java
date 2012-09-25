package com.lateralthoughts.devinlove.domain;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ToolTest {

	private Tool tool;

	@Before
	public void setup() {
		tool = new Tool();
	}

	@Test
	public void when_setting_name_then_name_is_retrieved() {
		tool.setName("Maven");
		assertThat(tool.getName()).isEqualTo("Maven");
	}

	@Test
	public void when_setting_version_then_is_retrieved() {
		tool.setVersion("3.0.5");
		assertThat(tool.getVersion()).isEqualTo("3.0.5");
	}

	@Test
	public void when_setting_a_creation_date_then_retrieved() {
		Date creationDate = new Date();
		tool.setCreationDate(creationDate);
		assertThat(tool.getCreationDate().getTime()).isEqualTo(creationDate.getTime());
	}

	@Test
	public void when_setting_category_then_retrieved() {
		Category category = new Category();
		category.setName("Software build");
		tool.setCategory(category);
		assertThat(tool.getCategory()).isEqualTo(category);
	}

	@Test
	public void when_setting_is_revolutionary_then_retrieved() {
		tool.setRevolutionary(true);
		assertThat(tool.isRevolutionary()).isTrue();
	}

	@Test
	public void when_adding_author_then_retrieved() {
		Person johnDoe = new Person();
		johnDoe.setFirstName("John");
		johnDoe.setLastName("Doe");
		Person janeDoe = new Person();
		janeDoe.setFirstName("Jane");
		janeDoe.setLastName("Doe");
		tool.addAuthors(johnDoe, janeDoe);
		assertThat(tool.getAuthors()).containsOnly(johnDoe, janeDoe);
	}

	@Test(expected = NullPointerException.class)
	public void when_adding_null_authors_then_exception() {
		tool.addAuthors(null);
	}

	@Test(expected = NullPointerException.class)
	public void when_adding_null_author_then_exception() {
		tool.addAuthors((Person[]) null);
	}
}
