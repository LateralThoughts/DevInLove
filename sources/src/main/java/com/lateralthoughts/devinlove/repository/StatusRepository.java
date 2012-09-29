package com.lateralthoughts.devinlove.repository;

import com.lateralthoughts.devinlove.domain.Status;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface StatusRepository extends GraphRepository<Status> {}
