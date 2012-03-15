package com.lateralthoughts.devinlove.controller;

import com.lateralthoughts.devinlove.domain.Mascot;
import com.lateralthoughts.devinlove.repository.MascotRepository;
import org.neo4j.helpers.collection.ClosableIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("latestMascots",
                takeTheNThFirst(mascotRepository.findAll(), 6));
        return "index";
    }
    
    public static <T> List<T> takeTheNThFirst(ClosableIterable<T> list, int nth) {
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
}
