package com.lateralthoughts.devinlove.repository;

import com.lateralthoughts.devinlove.domain.Mascot;
import com.lateralthoughts.devinlove.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static com.lateralthoughts.devinlove.domain.ProfoundIdentity.DEVELOPER;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:devinlove-core.xml",
    "classpath:devinlove-security.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	private Person person;

	@Before
	public void setup() {
		person = new Person();
		person.setFirstName("Florent");
		person.setLastName("Biville");
		person.setShoeSize(42);
		person.setProfoundIdentity(DEVELOPER);
		person.setFavoriteColor("Blue");
        person.setPassword("s3cret");
	}

	@Test
	public void when_inserting_then_stored_with_hashed_password() {
		assertThat(personRepository).isNotNull();
		personRepository.persist(person);
		assertThat(person.getId()).isGreaterThan(0L);
        assertThat(person.getPassword()).hasSize(80);
	}
}
