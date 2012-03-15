package com.lateralthoughts.devinlove.domain;


import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Places where people (usually geeks) meet-up around a subject a tool or a
 * common enemy.
 */
@NodeEntity
public class Meetup {

	@GraphId
	private Long id;
	private DateTime startDate;
	private DateTime endDate;
	private final ArrayList<TalkSubject> subjects = new ArrayList<TalkSubject>();
	private GeographicalLocation location;

	public void setStartDate(final Date date) {
		startDate = new DateTime(date);
	}

	public Date getStartDate() {
		return startDate.toDate();
	}

	public void setEndDate(final Date date) {
		endDate = new DateTime(date);
	}

	public Date getEndDate() {
		return endDate.toDate();
	}

	public void addSubject(final TalkSubject... meetupSubjects) {
		checkArgument(meetupSubjects != null);
		List<TalkSubject> subjects = asList(meetupSubjects);
		checkArgument(!subjects.contains(null));
		this.subjects.addAll(subjects);
	}

	public List<TalkSubject> getSubjects() {
		return subjects;
	}

	public void setLocation(final GeographicalLocation location) {
		this.location = location;
	}

	public GeographicalLocation getLocation() {
		return location;
	}
}
