package com.endava.webflux.service.impl;

import com.endava.webflux.model.Person;
import com.endava.webflux.service.PersonServiceWebFlux;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class PersonServiceWebFluxImpl implements PersonServiceWebFlux {

    @Override
    public Mono<Person> getPersonByName() {
        return Mono.just(new Person("Alice", 20L));
    }

    @Override
    public Flux<Person> getPeople() {

        return Flux.just(new Person("Alice", 20L),
                         new Person("Bob", 21L),
                         new Person("Charlie", 22L)
                    )
                .delaySequence(Duration.ofSeconds(3));

    }

}
