package com.lateralthoughts.devinlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

	@RequestMapping(value = "/index.html", method = GET)
    public String index(final Model model) throws Exception {
        return "index";
    }
}
