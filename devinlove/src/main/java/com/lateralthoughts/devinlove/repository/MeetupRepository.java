package com.lateralthoughts.devinlove.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.lateralthoughts.devinlove.domain.Meetup;

public interface MeetupRepository extends GraphRepository<Meetup>{
}
