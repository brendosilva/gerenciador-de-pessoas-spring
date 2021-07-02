package com.digital.apiPerson.service;

import com.digital.apiPerson.DTO.MessageResponseDTO;
import com.digital.apiPerson.entities.Person;
import com.digital.apiPerson.repository.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    private PersonRepositorie personRepositorie;

    @Autowired
    public PersonService(PersonRepositorie personRepositorie) {
        this.personRepositorie = personRepositorie;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson =  personRepositorie.save(person);
        return MessageResponseDTO.builder().message("Created person " + savedPerson.getId()).build();
    }
}
