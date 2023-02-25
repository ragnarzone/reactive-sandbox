package com.example.reactivesandbox;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class ReactiveSandboxTest {
    Person michael = new Person("Michael", "Weston");
    Person fiona = new Person("Fiona", "Glenanne");
    Person sam = new Person("Sam", "Axe");
    Person jesse = new Person("Jess", "Porter");

    @Test
    public void monoTests() {
        // create new person mono
        Mono<Person> personMono = Mono.just(michael);

        // get person object from mono publisher
        Person person = personMono.block();

        // output name
        log.info(person.sayMyName());
    }

    @Test
    public void monoTransform() {
        // create new person mono
        Mono<Person> personMono = Mono.just(fiona);

        PersonCommand command = personMono.map(PersonCommand::new).block();

        log.info(command.sayMyName());
    }

    @Test(expected = NullPointerException.class)
    public void monoFilter() {
        // create new person mono
        Mono<Person> personMono = Mono.just(sam);

        // filter
        Person samAxe = personMono
                .filter(person -> person.getFirstName().equalsIgnoreCase("foo"))
                .block();

        log.info(samAxe.sayMyName()); // here throws NPE
    }

}
