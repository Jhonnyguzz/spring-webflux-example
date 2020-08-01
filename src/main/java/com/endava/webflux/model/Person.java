package com.endava.webflux.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private String name;
    private long age;

}
