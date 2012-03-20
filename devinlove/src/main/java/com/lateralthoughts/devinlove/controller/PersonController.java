package com.lateralthoughts.devinlove.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.domain.Status;
import com.lateralthoughts.devinlove.domain.StatusRedaction;
import com.lateralthoughts.devinlove.framework.conversion.StatusPropertyEditor;
import com.lateralthoughts.devinlove.framework.mvc.response.NotFoundException;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import com.lateralthoughts.devinlove.service.StatusService;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private StatusService statusService;

	@InitBinder("statusCommand")
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Status.class, new StatusPropertyEditor());
	}


	@RequestMapping(value = "/profiles.html", method = GET)
	public ModelAndView displayProfiles(@RequestParam(value = "p", defaultValue = "0") final int page) {
		ModelAndView modelAndView = new ModelAndView("profiles");
		List<Person> profiles = personRepository.findAll(new PageRequest(page, 10)).getContent();
		modelAndView.addObject("profiles", profiles);
		return modelAndView;
	}

	@RequestMapping(value = "/profile-{id}.html", method = GET)
	public ModelAndView displayProfile(@PathVariable("id") final long island /* ahah */, @RequestParam(value = "p", defaultValue = "1") int statusPage) {
		if (statusPage < 1)
			statusPage = 1;
		ModelAndView modelAndView = new ModelAndView("profile");
		Person person = retrievePerson(island);
		modelAndView.addObject("guy", person);
		modelAndView.addObject("statusCommand", new Status(""));
		retrieveStatuses(statusPage, modelAndView, person);
		modelAndView.addObject("tools", personRepository.findTools(person.getId()));
		return modelAndView;
	}


	private void retrieveStatuses(final int page, final ModelAndView modelAndView, final Person person) {
		Page<StatusRedaction> sortedStatuses = personRepository.findSortedStatuses(person.getId(), new PageRequest(page - 1, 10));
		modelAndView.addObject("statuses", sortedStatuses.getContent());
		modelAndView.addObject("statusCurrentPage", sortedStatuses.getNumber() + 1);
		modelAndView.addObject("hasPreviousPage", sortedStatuses.hasPreviousPage());
		modelAndView.addObject("hasNextPage", sortedStatuses.hasNextPage());
	}

	@RequestMapping(value = "/profile-{id}.html", method = POST)
	public String save(@PathVariable("id") final long id, @ModelAttribute("statusCommand") final Status status) {
		Person author = retrievePerson(id);
		statusService.saveNewStatus(status, author);
		return "redirect:" + profileOf(author);
	}

	private String profileOf(final Person author) {
		return "/profile-" + author.getId().longValue() + ".html";
	}

	private Person retrievePerson(final long id) {
		Person person = personRepository.findOne(Long.valueOf(id));
		if (person == null) {
			throw new NotFoundException();
		}
		/*
		 * for (StatusRedaction status : person.getStatuses()) { String
		 * statusMessage = status.getStatusMessage();
		 * System.out.println(statusMessage); }
		 */
		return person;
	}
}
