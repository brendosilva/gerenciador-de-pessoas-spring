package com.digital.apiPerson.mappers;

import com.digital.apiPerson.DTO.request.PersonDTO;
import com.digital.apiPerson.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Named("birthDate")
    @Mapping(target = "birthDate", source = "birthDate" ,dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
