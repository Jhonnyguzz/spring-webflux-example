package com.endava.webflux.service;

import com.endava.webflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonService {

    Person getPersonByName();

    List<Person> getPeople();
}
