package com.lateralthoughts.devinlove.framework;

import static com.lateralthoughts.devinlove.domain.ProfoundIdentity.DEVELOPER;

import java.util.Date;

import com.lateralthoughts.devinlove.domain.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.lateralthoughts.devinlove.repository.CategoryRepository;
import com.lateralthoughts.devinlove.repository.MascotRepository;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import com.lateralthoughts.devinlove.repository.ToolRepository;

@Service
public class GraphPopulator implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private MascotRepository mascotRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private ToolRepository toolRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		loadData();
	}

	public void loadData() {
		lockABunchOfMascotsInCagesBwahaha();
		createToolCategories();
		createOurBelovedTools();
		loadABunchOfPeopleIntoTheMatrix();
	}

	/**
	 * thanks Wikipedia! :)
	 * @see http://en.wikipedia.org/wiki/List_of_mascots
	 */
	private void lockABunchOfMascotsInCagesBwahaha() {
		mascotRepository.save(mascot("Django Pony"));
		mascotRepository.save(mascot("elePHPant"));
		mascotRepository.save(mascot("Tux"));
		mascotRepository.save(mascot("Mozilla"));
		mascotRepository.save(mascot("Geeko"));
		mascotRepository.save(mascot("Duke"));
		mascotRepository.save(mascot("Perl Camel"));
		mascotRepository.save(mascot("Android"));
		mascotRepository.save(mascot("Rhino"));
		mascotRepository.save(mascot("Clippy (Office)"));
	}

	private void createToolCategories() {
		categoryRepository.save(category("HARDWARE"));
		categoryRepository.save(category("OPERATING SYSTEM"));
		categoryRepository.save(category("LANGUAGE"));
		categoryRepository.save(category("LIBRARY"));
		categoryRepository.save(category("FRAMEWORK"));
		categoryRepository.save(category("DATABASE"));
		categoryRepository.save(category("TOOL"));
	}

	private void createOurBelovedTools() {
		toolRepository.save(tool("Java Standard Edition", "LANGUAGE", "1.7.3", 1996, 23, 1, false));
		toolRepository.save(tool("PHP", "LANGUAGE", "5.4.0", 1995, 8, 6, false));
		toolRepository.save(tool("Python", "LANGUAGE", "3.2.2", 1994, 1, 1, false));
		toolRepository.save(tool("Maven", "TOOL", "3.0.4", 2001, 1, 8, false));
		toolRepository.save(tool("Ubuntu", "OPERATING SYSTEM", "11.10", 2004, 20, 10, false));
		toolRepository.save(tool("Neo4J", "DATABASE", "1.6", 2007, 25, 12, true));
	}

	private void loadABunchOfPeopleIntoTheMatrix() {
		personRepository.save(person("Florent", "Biville", "blue", "Tux", DEVELOPER, 42, "Hello world", "Java Standard Edition"));
		personRepository.save(person("Olivier", "Girardot", "green", "Django Pony", DEVELOPER, 45, "A World Appart (Info)", "Python"));
	}

	private Category category(final String name) {
		Category category = new Category();
		category.setName(name);
		return category;
	}

	private Person person(final String firstName, final String lastName, final String color, final String mascotName, final ProfoundIdentity profoundIdentity, final int shoeSize, final String firstStatus, final String toolName) {
		Person person = new Person();
		person.setFavoriteColor(color);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setMascot(findMascot(mascotName));
		//person.setProfoundIdentity(profoundIdentity);
		person.setShoeSize(shoeSize);
		// person.addTool(findTool(toolName));
		person.addStatus(new Status("Hello world"), new Date());
		return person;
	}

	private Tool findTool(final String toolname) {
		return toolRepository.findByPropertyValue("name", toolname);
	}

	private Mascot findMascot(final String mascotName) {
		return mascotRepository.findByPropertyValue("name", mascotName);
	}

	private Tool tool(final String name, final String categoryName, final String currentVersion, final int year, final int month, final int day, final boolean isRevolutionary) {
		Tool tool = new Tool();
		tool.setName(name);
		tool.setCategory(findCategory(categoryName));
		tool.setVersion(currentVersion);
		tool.setCreationDate(date(year, month, day));
		tool.setRevolutionary(isRevolutionary);
		return tool;
	}

	private Category findCategory(final String categoryname) {
		return categoryRepository.findByPropertyValue("name", categoryname);
	}

	private Date date(final int year, final int month, final int day) {
		return new DateTime().withYear(year).withDayOfMonth(month).withMonthOfYear(day).toDate();
	}

	private Mascot mascot(final String name) {
		Mascot mascot = new Mascot();
		mascot.setName(name);
		return mascot;
	}
}
