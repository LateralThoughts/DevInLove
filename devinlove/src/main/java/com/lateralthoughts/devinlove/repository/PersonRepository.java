package com.lateralthoughts.devinlove.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.lateralthoughts.devinlove.domain.Person;

public interface PersonRepository extends GraphRepository<Person> {
    Person findById(String id);
}
