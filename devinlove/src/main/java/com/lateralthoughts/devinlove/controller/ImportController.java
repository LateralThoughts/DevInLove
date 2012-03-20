package com.lateralthoughts.devinlove.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lateralthoughts.devinlove.service.GraphPopulator;

@Controller
public class ImportController {

	@Autowired
	private GraphPopulator populator;
	
	@RequestMapping(value = "/import.html", method = GET)
	public String importData() {
		populator.loadData();
		return "redirect:/profiles.html";
	}
}
