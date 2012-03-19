package com.lateralthoughts.devinlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(final Model model) throws Exception {
        return "index";
    }

    @RequestMapping(value = "/search.html")
    public String search(final Model model) throws Exception {
		// personRepository.findAllByQuery();
        return "index";
    }
}
