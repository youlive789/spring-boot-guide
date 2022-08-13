package com.spring.guide.guide.five;

import org.springframework.stereotype.Service;

import com.spring.guide.guide.five.dto.Person;

@Service
public class FiveService {

    public Person getNamedPerson(String name) {
        Person person = new Person();
        person.setName(name);
        return person;
    }

    public Person getSamplePerson() {
        return new Person();
    }
}
