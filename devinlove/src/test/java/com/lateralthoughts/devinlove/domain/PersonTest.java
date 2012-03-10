package com.lateralthoughts.devinlove.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class PersonTest {
	@Test
	public void when_instanciating_with_names_then_retrieved() {
		Person person = new Person("John", "Doe");
		assertThat(person.getFirstName()).isEqualTo("John");
		assertThat(person.getLastName()).isEqualTo("Doe");
	}
}
