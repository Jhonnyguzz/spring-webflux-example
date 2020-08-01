package com.endava.webflux;

import com.endava.webflux.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@SpringBootApplication
public class WebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxApplication.class, args);

		WebClient client = WebClient.create("http://localhost:8080");

		Flux<Person> fluxPerson1 = client.get()
				.uri("/v2/person/all")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Person.class);

		Flux<Person> fluxPerson2 = client.get()
				.uri("/v2/person/all")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Person.class);

		Flux<Person> fluxPerson3 = client.get()
				.uri("/v2/person/all")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Person.class);

		Flux.merge(fluxPerson1, fluxPerson2, fluxPerson3)
				.subscribe(System.out::println);



		System.out.println("RestTemplate");

		Instant start = Instant.now();

		RestTemplate restTemplate = new RestTemplate();
		Person[] people1 = restTemplate.getForObject("http://localhost:8080/v1/person/all", Person[].class);
		Person[] people2 = restTemplate.getForObject("http://localhost:8080/v1/person/all", Person[].class);
		Person[] people3 = restTemplate.getForObject("http://localhost:8080/v1/person/all", Person[].class);

		Stream.of(Arrays.asList(people1), Arrays.asList(people2), Arrays.asList(people3))
				.flatMap(Collection::stream)
				.forEach(System.out::println);

		Instant end = Instant.now();

		long timeElapsed = Duration.between(start, end).toMillis();
		int seconds = (int) ((timeElapsed / 1000) % 60);
		System.out.println("Time elapsed:" + seconds);

	}

}
