package com.digital.apiPerson.controllers;

import com.digital.apiPerson.DTO.MessageResponseDTO;
import com.digital.apiPerson.entities.Person;
import com.digital.apiPerson.repository.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepositorie personRepositorie;

    @Autowired
    public PersonController(PersonRepositorie personRepositorie) {
        this.personRepositorie = personRepositorie;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody  Person person) {
        Person savedPerson =  personRepositorie.save(person);
        return MessageResponseDTO.builder().message("Created person " + savedPerson.getId()).build();
    }
}
