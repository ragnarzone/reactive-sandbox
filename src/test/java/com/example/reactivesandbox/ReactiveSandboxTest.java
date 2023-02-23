package com.example.reactivesandbox;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

@Slf4j
public class ReactiveSandboxTest {
    Person michael = new Person("Michael", "Weston");
    Person fiona = new Person("Fiona", "Glenanne");
    Person sam = new Person("Sam", "Axe");
    Person jesse = new Person("Jess", "Porter");

    @Test
    void monoTests() {
        // create new person mono
        Mono<Person> personMono = Mono.just(michael);

        // get person object from mono publisher
        Person person = personMono.block();

        // output name
        log.info(person.sayMyName());
    }
}
