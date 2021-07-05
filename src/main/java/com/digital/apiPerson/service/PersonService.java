package com.digital.apiPerson.service;

import com.digital.apiPerson.DTO.MessageResponseDTO;
import com.digital.apiPerson.DTO.request.PersonDTO;
import com.digital.apiPerson.entities.Person;
import com.digital.apiPerson.mappers.PersonMapper;
import com.digital.apiPerson.repository.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    private PersonRepositorie personRepositorie;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepositorie personRepositorie) {
        this.personRepositorie = personRepositorie;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
       Person personToSave = personMapper.toModel(personDTO);



        Person savedPerson =  personRepositorie.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person " + savedPerson.getId())
                .build();
    }
}
