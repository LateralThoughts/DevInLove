package com.lateralthoughts.devinlove.service;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.Status;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import com.lateralthoughts.devinlove.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
