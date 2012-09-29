package com.lateralthoughts.devinlove.repository;

import com.lateralthoughts.devinlove.domain.Category;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface CategoryRepository extends GraphRepository<Category> {}
