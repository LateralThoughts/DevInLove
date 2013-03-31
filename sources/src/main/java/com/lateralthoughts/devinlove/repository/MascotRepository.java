package com.lateralthoughts.devinlove.repository;

import com.lateralthoughts.devinlove.domain.Mascot;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface MascotRepository extends GraphRepository<Mascot> {
    Mascot findByName(String name);
}
