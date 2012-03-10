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

	@Test(expected = IllegalArgumentException.class)
	public void when_adding_nothing_then_exception() {
		tool.addBackingCompany(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_adding_null_provider_then_exception() {
		tool.addBackingCompany((Company[]) null);
	}

	@Test
	public void when_adding_providers_then_all_retrieved() {
		tool.addBackingCompany(new Company("Lateral Thoughts"), new Company("Sonatype"), new Company("SpringSource"));
		assertThat(tool.getBackingCompanies()).containsOnly(new Company("Lateral Thoughts"), new Company("Sonatype"), new Company("SpringSource"));
	}

	@Test
	public void when_setting_category_then_retrieved() {
		tool.setCategory(new Category("Software build"));
		assertThat(tool.getCategory()).isEqualTo(new Category("Software build"));
	}

	@Test
	public void when_setting_is_revolutionary_then_retrieved() {
		tool.setRevolutionary(true);
		assertThat(tool.isRevolutionary()).isTrue();
	}

	@Test
	public void when_adding_author_then_retrieved() {
		tool.addAuthor(new Person("John", "Doe"), new Person("Jane", "Doe"));
		assertThat(tool.getAuthors()).containsOnly(new Person("John", "Doe"), new Person("Jane", "Doe"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_adding_null_authors_then_exception() {
		tool.addAuthor(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_adding_null_author_then_exception() {
		tool.addAuthor((Person[]) null);
	}
}
