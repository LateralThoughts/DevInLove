package com.lateralthoughts.devinlove.service;


import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.neo4j.aspects.core.NodeBacked;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;


@Service
@Transactional
public class PersonService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PersonRepository graphPersonRepository;

    public void save(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        person.persist();
    }
}
