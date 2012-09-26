package com.lateralthoughts.devinlove.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lateralthoughts.devinlove.service.GraphPopulatorService;

@Controller
public class ImportController {

	@Autowired
	private GraphPopulatorService populatorService;
	
	@RequestMapping(value = "/import.html", method = GET)
	public String importData() {
		populatorService.loadData();
		return "redirect:/profiles.html";
	}
}
