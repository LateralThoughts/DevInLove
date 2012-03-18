package com.lateralthoughts.devinlove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.Status;
import com.lateralthoughts.devinlove.domain.StatusRedaction;

@Service
@Transactional
public class StatusService {

	@Autowired
	private Neo4jOperations template;

	public void saveNewStatus(final Status status, final Person author) {
		template.createRelationshipBetween(author, status, StatusRedaction.class, "WRITES", true);
	}
}
