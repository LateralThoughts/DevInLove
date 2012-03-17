package com.lateralthoughts.devinlove.domain;

import static com.lateralthoughts.devinlove.domain.Person.ProfoundIdentity.DEVELOPER;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class PersonTest {

	private Person johnDoe;
	private Mascot mascot;
	private Person janeDoe;
	private Tool tool;

	@Before
	public void setup() {
		johnDoe = new Person("John", "Doe");
		janeDoe = new Person("Jane", "Doe");
		mascot = new Mascot();
		mascot.setName("Elephpant");
		tool = new Tool();
		tool.setName("Maven");
	}

	@Test
	public void when_instanciating_with_names_then_retrieved() {
		assertThat(johnDoe.getFirstName()).isEqualTo("John");
		assertThat(johnDoe.getLastName()).isEqualTo("Doe");
	}

	@Test
	public void when_instanciating_similar_people_then_are_equal() {
		Person johnDoeBis = new Person("John", "Doe");
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
		assertThat(johnDoe.getFriends()).containsExactly(janeDoe);
	}

	@Test(expected = NullPointerException.class)
	public void when_adding_null_friends_then_exception() {
		johnDoe.addFriend(null);
	}

	@Test
	public void when_adding_tool_then_retrieved() {
		johnDoe.addTool(tool);
		assertThat(johnDoe.getTools()).containsExactly(tool);
	}

	@Test(expected = NullPointerException.class)
	public void when_adding_null_tool_then_exception() {
		johnDoe.addTool(null);
	}

	@Test
	public void when_setting_shoe_size_then_retrieved() {
		johnDoe.setShoeSize(42);
		assertThat(johnDoe.getShoeSize()).isEqualTo(42);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_setting_negative_shoe_size_then_exception() {
		johnDoe.setShoeSize(-50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_setting_too_large_shoe_size_then_exception() {
		johnDoe.setShoeSize(80);
	}
	
	@Test
	public void when_adding_status_then_retrieved() {
		String status = "I am hungry";
		johnDoe.addStatus(status);
		assertThat(johnDoe.getStatuses()).containsExactly(status);
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
