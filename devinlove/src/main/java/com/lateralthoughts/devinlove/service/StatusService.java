package com.lateralthoughts.devinlove.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.Status;
import com.lateralthoughts.devinlove.repository.StatusRepository;

@Service
@Transactional
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private Neo4jOperations template;

	public void saveNewStatus(final Status status, final Person author) {
		statusRepository.save(status);
		author.addStatus(template, status, new Date());
	}
}
