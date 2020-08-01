package com.endava.webflux.service;

import com.endava.webflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonServiceWebFlux {


    Mono<Person> getPersonByName();

    Flux<Person> getPeople();

}
