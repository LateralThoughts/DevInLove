package com.lateralthoughts.devinlove.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/index.html")
    public ModelAndView index() throws Exception {
        String aMessage = "Hello World MVC!";

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", aMessage);

        return modelAndView;
    }
}
