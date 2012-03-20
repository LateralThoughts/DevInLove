package com.lateralthoughts.devinlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@RequestMapping(value = "/search.html", method = RequestMethod.GET)
	public String search(@RequestParam(value = "search") final String search) {
		// argh not enough time ;(
		return "search";
	}
}
