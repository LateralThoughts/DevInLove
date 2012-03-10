package com.lateralthoughts.devinlove.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.lateralthoughts.devinlove.domain.Tool;

public interface ToolRepository extends GraphRepository<Tool> {
}
