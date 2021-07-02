package com.digital.apiPerson.repository;

import com.digital.apiPerson.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositorie extends JpaRepository<Person, Long> {
}
