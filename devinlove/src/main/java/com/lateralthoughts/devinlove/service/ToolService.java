package com.lateralthoughts.devinlove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.Tool;
import com.lateralthoughts.devinlove.domain.ToolAffinity;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import com.lateralthoughts.devinlove.repository.ToolRepository;

@Service
@Transactional
public class ToolService {
	@Autowired
	private ToolRepository toolRepository;
	@Autowired
	private PersonRepository personRepository;

	public void saveNewTool(final Tool tool, final ToolAffinity affinity, final Person user) {
		toolRepository.save(tool);
		user.addTool(tool, affinity);
		personRepository.save(user);
	}
}
