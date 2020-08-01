package com.endava.webflux.controller;

import com.endava.webflux.model.Person;
import com.endava.webflux.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1")
public class MVCController {

    private PersonService personService;

    @Autowired
    public MVCController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public Person getPersonByName(@PathVariable String id) {
        return null;
    }

    @GetMapping("/person/all")
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/person/full")
    public List<Person> getPeoplePostman() {
        return Stream.of(personService.getPeople(), personService.getPeople(), personService.getPeople())
				.flatMap(Collection::stream).collect(Collectors.toList());
    }
}
