package com.lateralthoughts.devinlove.controller;

import static java.util.Arrays.asList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lateralthoughts.devinlove.domain.Mascot;
import com.lateralthoughts.devinlove.repository.MascotRepository;

@Controller
public class HomeController {
    @Autowired
    MascotRepository mascotRepository;

    @RequestMapping(value = "/index.html")
    public String index(final Model model) throws Exception {
        Mascot mascot = new Mascot();
        mascot.name = "Django Pony";
        mascotRepository.save(mascot);
        model.addAttribute("message", "test");
		model.addAttribute("latestMascots", asList(new String[] { "a", "b", "c" }));
		return "index";
    }
}
