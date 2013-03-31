package com.lateralthoughts.devinlove.repository;

import com.lateralthoughts.devinlove.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final PasswordEncoder passwordEncoder;
    private final Neo4jOperations template;

    @Autowired
    public PersonRepositoryImpl(PasswordEncoder passwordEncoder,
                                Neo4jOperations template) {

        this.passwordEncoder = passwordEncoder;
        this.template = template;
    }

    @Override
    @Transactional
    public void persist(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        template.save(person);
    }
}
