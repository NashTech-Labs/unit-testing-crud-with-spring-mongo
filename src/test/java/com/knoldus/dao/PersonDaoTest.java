package com.knoldus.dao;

import com.knoldus.model.Person;
import com.knoldus.utils.ObjectCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest {

    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);

    private final PersonDao personDao = new PersonDao(personRepository);


    @Test
    void insertPersonData() {
        Mockito.when(personRepository.insert(Mockito.any(Person.class))).thenReturn(ObjectCreator.person);
        Person personData = personDao.insertPersonData(ObjectCreator.getPerson());
        assertEquals(personData, ObjectCreator.person);
    }

    @Test
    void getAllPersonInformation() {
        Mockito.when(personRepository.findAll()).thenReturn(Collections.singletonList(ObjectCreator.person));
        assertEquals(personDao.getAllPersonInformation(), Collections.singletonList(ObjectCreator.person));
    }

    @Test
    void getPersonInformationById() {
        Mockito.when(personRepository.findById(Mockito.anyString())).thenReturn(Optional.of(ObjectCreator.person));
        Optional<Person> optionalPerson = personDao.getPersonInformationById(Mockito.anyString());
        assertEquals(optionalPerson,Optional.of(ObjectCreator.person));
    }

    @Test
    void updatePersonUsingId() {
        Mockito.when(personRepository.findById(Mockito.anyString())).thenReturn(Optional.of(ObjectCreator.person));
        Mockito.when(personRepository.save(Mockito.any())).thenReturn(ObjectCreator.person);
        Person personData = personDao.updatePersonUsingId(Mockito.anyString(), ObjectCreator.person);
        assertEquals(personData, ObjectCreator.person);
    }
}