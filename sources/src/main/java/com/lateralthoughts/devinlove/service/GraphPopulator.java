package com.lateralthoughts.devinlove.service;

import com.lateralthoughts.devinlove.domain.*;
import com.lateralthoughts.devinlove.repository.CategoryRepository;
import com.lateralthoughts.devinlove.repository.MascotRepository;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import com.lateralthoughts.devinlove.repository.ToolRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static com.lateralthoughts.devinlove.domain.ProfoundIdentity.DEVELOPER;
import static com.lateralthoughts.devinlove.domain.ProfoundIdentity.SALESMAN;
import static com.lateralthoughts.devinlove.domain.ToolAffinity.HATE;
import static com.lateralthoughts.devinlove.domain.ToolAffinity.LOVE;

@Component
@Transactional
public class GraphPopulator {

    @Autowired
	private MascotRepository mascotRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StatusService statusService;

    @PostConstruct
	public void loadData() {
		lockABunchOfMascotsInCagesBwahaha();
		createToolCategories();
		createOurBelovedTools();
		loadABunchOfPeopleIntoTheMatrix();
	}

	/**
	 * thanks Wikipedia! :)
	 * voir http://en.wikipedia.org/wiki/List_of_mascots
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
		categoryRepository.save(category("IDE"));
		categoryRepository.save(category("SCM"));
	}

	private void createOurBelovedTools() {
		toolRepository.save(tool("Perforce", "SCM", "2011.1", 1800, 1, 1, false));
		toolRepository.save(tool("Git", "SCM", "1.7.21.1", 2005, 4, 7, true));
		toolRepository.save(tool("IntelliJ IDEA", "IDE", "1.7.3", 1996, 23, 1, false));
		toolRepository.save(tool("Eclipse", "IDE", "4.2", 1996, 23, 1, false));
		toolRepository.save(tool("Java Standard Edition", "LANGUAGE", "1.7.3", 1996, 23, 1, false));
		toolRepository.save(tool("PHP", "LANGUAGE", "5.4.7", 1995, 8, 6, false));
		toolRepository.save(tool("Python", "LANGUAGE", "3.2.3", 1994, 1, 1, false));
		toolRepository.save(tool("Maven", "TOOL", "3.0.4", 2001, 1, 8, false));
		toolRepository.save(tool("Ubuntu", "OPERATING SYSTEM", "12.10", 2004, 20, 10, false));
		toolRepository.save(tool("Neo4J", "DATABASE", "1.8.2", 2007, 25, 12, true));
	}

	private void loadABunchOfPeopleIntoTheMatrix() {
		Person florent = person("Florent", "Biville", "blue", mascotRepository.findByName("Tux"), DEVELOPER, 42, tastesOfFlorent(), "s3cret", "fbiville");
        personRepository.persist(florent);
		statusService.saveNewStatus(new Status("Associé chez Lateral-Thoughts"), florent);

        Person olivier = person("Olivier", "Girardot", "green", mascotRepository.findByName("Django Pony"), DEVELOPER, 45, tasteOfOlivier(), "s3cret", "ogirardot");
		personRepository.persist(olivier);
		statusService.saveNewStatus(new Status("Fondateur et associé chez Lateral-Thoughts"), olivier);

        Person cedric = person("Cédric", "Fauvet", "yellow", null, SALESMAN, 44, tastesOfCedric(), "s3cret", "cfauvet");
        personRepository.persist(cedric);
        statusService.saveNewStatus(new Status("Premier meetup parisien. Merci So@t!"), cedric);

        Person stefan = person("Stefan", "Armbruster", "red", mascotRepository.findByName("Duke"), DEVELOPER, 43, tastesOfStefan(), "s3cret", "sarmbruster");
        personRepository.persist(stefan);
        statusService.saveNewStatus(new Status("Long live Neo4J!"), stefan);
    }

	private Map<String, ToolAffinity> tasteOfOlivier() {
		Map<String, ToolAffinity> olivierAffinity = new HashMap<String, ToolAffinity>();
		olivierAffinity.put("Python", LOVE);
		olivierAffinity.put("Git", LOVE);
		olivierAffinity.put("IntelliJ IDEA", LOVE);
		return olivierAffinity;
	}

	private Map<String, ToolAffinity> tastesOfFlorent() {
		Map<String, ToolAffinity> floAffinity = new HashMap<String, ToolAffinity>();
		floAffinity.put("Java Standard Edition", LOVE);
		floAffinity.put("Perforce", HATE);
		floAffinity.put("Git", LOVE);
		floAffinity.put("Eclipse", LOVE);
		return floAffinity;
	}

    private Map<String, ToolAffinity> tastesOfCedric() {
        Map<String, ToolAffinity> cedricAffinity = new HashMap<String, ToolAffinity>();
        cedricAffinity.put("Neo4J", LOVE);
        return cedricAffinity;
    }

    private Map<String, ToolAffinity> tastesOfStefan() {
        Map<String, ToolAffinity> stefanAffinity = new HashMap<String, ToolAffinity>();
        stefanAffinity.put("Neo4J", LOVE);
        return stefanAffinity;
    }

	private Category category(final String name) {
		Category category = new Category();
		category.setName(name);
		return category;
	}

	private Person person(final String firstName, final String lastName, final String color, final Mascot mascot, final ProfoundIdentity profoundIdentity, final int shoeSize, final Map<String, ToolAffinity> toolAffinities, String password, String login) {
		Person person = new Person();
		person.setFavoriteColor(color);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setMascot(mascot);
		person.setProfoundIdentity(profoundIdentity);
		person.setShoeSize(shoeSize);
        person.setLogin(login);
        person.setPassword(password);
		for (Entry<String, ToolAffinity> toolAffinity : toolAffinities.entrySet()) {
			person.addTool(findTool(toolAffinity.getKey()), toolAffinity.getValue());
		}
		return person;
	}

	private Tool findTool(final String toolname) {
		return toolRepository.findByPropertyValue("name", toolname);
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
