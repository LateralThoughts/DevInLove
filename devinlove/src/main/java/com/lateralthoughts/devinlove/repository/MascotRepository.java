package com.lateralthoughts.devinlove.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.lateralthoughts.devinlove.domain.Mascot;

public interface MascotRepository extends GraphRepository<Mascot> {}
