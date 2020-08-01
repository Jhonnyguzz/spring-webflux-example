package com.endava.webflux.service.impl;

import com.endava.webflux.model.Person;
import com.endava.webflux.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPersonByName() {
        return new Person("Alice", 20L);
    }

    @Override
    public List<Person> getPeople() {
        try {
            //Some lazy resource such as DB or network operation
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(
                new Person("Alice", 20L),
                new Person("Bob", 21L),
                new Person("Charlie", 22L)
        );
    }
}
