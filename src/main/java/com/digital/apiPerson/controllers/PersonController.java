package com.digital.apiPerson.controllers;

import com.digital.apiPerson.DTO.MessageResponseDTO;
import com.digital.apiPerson.entities.Person;
import com.digital.apiPerson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody  Person person) {
        return personService.createPerson(person);
    }
}
