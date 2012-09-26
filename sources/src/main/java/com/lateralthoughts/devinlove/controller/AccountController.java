package com.lateralthoughts.devinlove.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AccountController {

    @RequestMapping(value = "/login.html", method = GET)
    public String login(Principal user) {
        return "login";
    }

    @RequestMapping(value = "/authenticate.html", method = POST)
    public String doLogin(Principal user) {
        return "login";
    }
}
