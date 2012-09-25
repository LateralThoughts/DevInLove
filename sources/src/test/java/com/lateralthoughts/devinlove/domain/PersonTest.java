package com.lateralthoughts.devinlove.domain;

import static com.lateralthoughts.devinlove.domain.ProfoundIdentity.DEVELOPER;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	private Person johnDoe;
	private Mascot mascot;
	private Person janeDoe;
	private Tool maven;

	@Before
	public void setup() {
		johnDoe = new Person();
		johnDoe.setFirstName("John");
		johnDoe.setLastName("Doe");
		janeDoe = new Person();
		janeDoe.setFirstName("Jane");
		janeDoe.setLastName("Doe");
		mascot = new Mascot();
		mascot.setName("Elephpant");
		maven = new Tool();
		maven.setName("Maven");
	}

	@Test
	public void when_instanciating_with_names_then_retrieved() {
		assertThat(johnDoe.getFirstName()).isEqualTo("John");
		assertThat(johnDoe.getLastName()).isEqualTo("Doe");
	}

	@Test
	public void when_instanciating_similar_people_then_are_equal() {
		Person johnDoeBis = new Person();
		johnDoeBis.setFirstName("John");
		johnDoeBis.setLastName("Doe");
		assertThat(johnDoe).isEqualTo(johnDoeBis);
		assertThat(johnDoe).isNotEqualTo(janeDoe);
	}

	@Test
	public void when_setting_color_then_retrieved() {
		johnDoe.setFavoriteColor("blue");
		assertThat(johnDoe.getFavoriteColor()).isEqualToIgnoringCase("blue");
	}

	@Test(expected = NullPointerException.class)
	public void when_setting_null_color_then_exception() {
		johnDoe.setFavoriteColor(null);
	}

	@Test
	public void when_setting_mascot_then_retrieved() {
		johnDoe.setMascot(mascot);
		assertThat(johnDoe.getMascot()).isEqualTo(mascot);
	}

	@Test
	public void when_requesting_friends_then_retrieved() {
		assertThat(johnDoe.getFriends()).isEmpty();
	}

	@Test
	public void when_adding_friends_then_retrieved() {
		johnDoe.addFriend(janeDoe);
		assertThat(johnDoe.getFriends()).containsOnly(janeDoe);
	}

	@Test(expected = NullPointerException.class)
	public void when_adding_null_friends_then_exception() {
		johnDoe.addFriend(null);
	}

	@Test
	public void when_setting_shoe_size_then_retrieved() {
		johnDoe.setShoeSize(42);
		assertThat(johnDoe.getShoeSize()).isEqualTo(42);
	}

	@Test
	public void when_setting_identity_then_retrieved() {
		johnDoe.setProfoundIdentity(DEVELOPER);
		assertThat(johnDoe.getProfoundIdentity());
	}

	@Test(expected = NullPointerException.class)
	public void when_setting_null_identity_then_exception() {
		johnDoe.setProfoundIdentity(null);
	}

}
