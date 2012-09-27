package com.lateralthoughts.devinlove.controller;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SearchController {

    @Autowired
    private PersonRepository finder;

    @RequestMapping(value = "/search.json", method = GET)
    @ResponseBody
    public List<Person> autocomplete(@RequestParam(value = "term") final String term) {
        return newArrayList(finder.findByFirstNameLike(term));
    }
}
