package com.lateralthoughts.devinlove.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.lateralthoughts.devinlove.domain.Company;

public interface CompanyRepository extends GraphRepository<Company>{
}
