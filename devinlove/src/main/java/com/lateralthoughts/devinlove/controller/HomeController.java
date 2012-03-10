package com.lateralthoughts.devinlove.controller;

import com.lateralthoughts.devinlove.domain.Mascot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: ogirardot
 * Date: 10/03/12
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {
    @Autowired Neo4jTemplate template;

    @Transactional
    @RequestMapping(value = "/index.html")
    public ModelAndView index() throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        Mascot m = new Mascot();
        m.name = "Django Pony";
        template.save(m);

        modelAndView.addObject("latestMascots", template.findAll(Mascot.class));

        return modelAndView;
    }
}
