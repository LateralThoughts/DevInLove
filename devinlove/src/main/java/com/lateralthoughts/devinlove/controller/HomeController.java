package com.lateralthoughts.devinlove.controller;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.helpers.collection.ClosableIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lateralthoughts.devinlove.domain.Mascot;
import com.lateralthoughts.devinlove.repository.MascotRepository;

@Controller
public class HomeController {

	@Autowired
	private MascotRepository mascotRepository;

    @RequestMapping(value = "/index.html")
    public String index(final Model model) throws Exception {
        Mascot mascot = new Mascot();
		mascot.setName("Django Pony");
        mascotRepository.save(mascot);
        model.addAttribute("message", "test");
        model.addAttribute("latestMascots",
                takeTheNThFirst(mascotRepository.findAll(), 6));
        return "index";
    }
    
    public static <T> List<T> takeTheNThFirst(final ClosableIterable<T> list, final int nth) {
        List<T> out = new ArrayList<T>();
        for (T mascot : list) {
            out.add(mascot);
            if (out.size() == nth) {
                break;
            }
        }
        list.close();
        return out;
    }

    @RequestMapping(value = "/search.html")
    public String search(final Model model) throws Exception {
		// personRepository.findAllByQuery();
        return "index";
    }
}
