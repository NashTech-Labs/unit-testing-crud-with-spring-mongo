package com.knoldus.service;

import com.knoldus.dao.PersonDao;
import com.knoldus.dao.PersonRepository;
import com.knoldus.model.Person;
import com.knoldus.utils.ObjectCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static com.knoldus.utils.ObjectCreator.*;

class PersonServiceTest {

    private final PersonDao personDao = Mockito.mock(PersonDao.class);
    private final PersonService personService = new PersonService(personDao);

    @Test
    void insertPersonData() {
        Mockito.when(personDao.insertPersonData(Mockito.any(Person.class))).thenReturn(ObjectCreator.person);
        Person personData = personService.insertPersonData(ObjectCreator.getPerson());
        Assertions.assertEquals(personData, ObjectCreator.person);
    }

    @Test
    void getAllPersonInformation() {
        Mockito.when(personDao.getAllPersonInformation()).thenReturn(ObjectCreator.personCollection);
        Assertions.assertEquals(personService.getAllPersonInformation(), ObjectCreator.personCollection);
    }

    @Test
    void getPersonInformationUsingId() {
        Mockito.when(personDao.getPersonInformationById(Mockito.anyString())).thenReturn(ObjectCreator.personOptional);
        Optional<Person> personData = personService.getPersonInformationUsingId(Mockito.anyString());
        Assertions.assertEquals(personData, ObjectCreator.personOptional);
    }
}