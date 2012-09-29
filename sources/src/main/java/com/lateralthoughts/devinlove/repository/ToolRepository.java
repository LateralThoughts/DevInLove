package com.lateralthoughts.devinlove.repository;

import com.lateralthoughts.devinlove.domain.Tool;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ToolRepository extends GraphRepository<Tool> {}
