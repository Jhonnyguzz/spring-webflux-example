package com.endava.webflux.controller;

import com.endava.webflux.model.Person;
import com.endava.webflux.service.PersonServiceWebFlux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
public class WebFluxController {

    private PersonServiceWebFlux personServiceWebFlux;

    @Autowired
    public WebFluxController(PersonServiceWebFlux personServiceWebFlux) {
        this.personServiceWebFlux = personServiceWebFlux;
    }

    @GetMapping("/person/{id}")
    public Mono<Person> getPersonByName(@PathVariable String id) {
        return null;
    }

    @GetMapping("/person/all")
    public Flux<Person> getPeople() {
        return personServiceWebFlux.getPeople();
    }

    @GetMapping("/person/full")
    public Flux<Person> getPeoplePostman() {
        return Flux.merge(personServiceWebFlux.getPeople(), personServiceWebFlux.getPeople(), personServiceWebFlux.getPeople());
    }
}
