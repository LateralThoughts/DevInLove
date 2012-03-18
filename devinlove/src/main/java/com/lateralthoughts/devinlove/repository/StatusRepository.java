package com.lateralthoughts.devinlove.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.lateralthoughts.devinlove.domain.Status;

public interface StatusRepository extends GraphRepository<Status> {}
