package com.lateralthoughts.devinlove.domain;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class MeetupTest {
	private Meetup meetup;

	@Before
	public void setup() {
		meetup = new Meetup();
	}

	@Test
	public void when_setting_start_date_then_retrieved() {
		final Date startDate = new Date();
		meetup.setStartDate(startDate);
		assertThat(meetup.getStartDate().getTime()).isEqualTo(startDate.getTime());
	}

	@Test
	public void when_setting_end_date_then_retrieved() {
		final Date endDate = new Date();
		meetup.setEndDate(endDate);
		assertThat(meetup.getEndDate().getTime()).isEqualTo(endDate.getTime());
	}

	@Test
	public void when_adding_subjects_then_retrieved() {
		meetup.addSubject(new TalkSubject("Maven: the definitive conference"), new TalkSubject("Neo4J: there is no graph!"));
		assertThat(meetup.getSubjects()).containsOnly(new TalkSubject("Maven: the definitive conference"), new TalkSubject("Neo4J: there is no graph!"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_adding_null_subjects_then_exception() {
		meetup.addSubject(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_adding_null_subject_then_exception() {
		meetup.addSubject((TalkSubject) null);
	}

	@Test
	public void when_setting_location_then_retrieved() {
		GeographicalLocation location = new GeographicalLocation();
		meetup.setLocation(location);
		assertThat(meetup.getLocation()).isEqualTo(location);
	}
}
