package com.lateralthoughts.devinlove.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class PersonTest {

	@Test
	public void when_instanciating_with_names_then_retrieved() {
		Person johnDoe = new Person("John", "Doe");
		assertThat(johnDoe.getFirstName()).isEqualTo("John");
		assertThat(johnDoe.getLastName()).isEqualTo("Doe");
	}

	@Test
	public void when_instanciating_similar_people_then_are_equal() {
		Person johnDoe = new Person("John", "Doe");
		Person johnDoeBis = new Person("John", "Doe");
		Person janeDoe = new Person("Jane", "Doe");
		assertThat(johnDoe).isEqualTo(johnDoeBis);
		assertThat(johnDoe).isNotEqualTo(janeDoe);
	}
}
