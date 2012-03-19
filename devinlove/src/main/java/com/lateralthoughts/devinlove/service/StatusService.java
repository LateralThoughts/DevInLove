package com.lateralthoughts.devinlove.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.Status;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import com.lateralthoughts.devinlove.repository.StatusRepository;

@Service
@Transactional
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private PersonRepository personRepository;

	public void saveNewStatus(final Status status, final Person author) {
		statusRepository.save(status);
		author.addStatus(status, new Date());
		personRepository.save(author);
	}
}
