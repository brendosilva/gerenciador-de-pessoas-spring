package com.digital.apiPerson.service;

import com.digital.apiPerson.DTO.MessageResponseDTO;
import com.digital.apiPerson.DTO.request.PersonDTO;
import com.digital.apiPerson.entities.Person;
import com.digital.apiPerson.exception.PersonNotFoundException;
import com.digital.apiPerson.mappers.PersonMapper;
import com.digital.apiPerson.repository.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepositorie.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO fiindById(Long id) throws PersonNotFoundException {

       Person person = verifyIfExists(id);

       return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepositorie.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepositorie.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
