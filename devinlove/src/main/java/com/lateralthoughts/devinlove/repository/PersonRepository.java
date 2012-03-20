package com.lateralthoughts.devinlove.repository;

import static org.springframework.data.neo4j.annotation.QueryType.Cypher;
import static org.springframework.data.neo4j.annotation.QueryType.Gremlin;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.StatusRedaction;
import com.lateralthoughts.devinlove.domain.ToolUsage;

public interface PersonRepository extends GraphRepository<Person> {

	/*
	 * QUERY MEANING: get all relationships "WRITES" a.k.a. StatusRedaction
	 * related to the identified Person, sorted by descending creation date
	 */
	@Query(type = Cypher, value = "START person=node({0}) MATCH (person)-[relationship:WRITES]->() RETURN relationship ORDER BY relationship.creationDate DESC")
	Page<StatusRedaction> findSortedStatuses(Long personId, Pageable pageRequest);

	/*
	 * QUERY MEANING: get all outgoing edges of type WORKS_WITH (a.k.a.
	 * ToolUsage) of the specified vertex
	 */
	@Query(type = Gremlin, value = "g.v(id).outE('WORKS_WITH')")
	Set<ToolUsage> findTools(@Param("id") Long personId);
}
