package com.lateralthoughts.devinlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping(value = "/notFound.html")
    public String notFound() {
        return "notFound";
    }

    @RequestMapping(value = "/oops.html")
    public String error() {
        return "error";
    }
}
