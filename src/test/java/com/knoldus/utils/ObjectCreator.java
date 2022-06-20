package com.knoldus.utils;

import com.knoldus.model.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class ObjectCreator {
    public static Person person = getPerson();
    public static Collection<Person> personCollection = Collections.singletonList(getPerson());
    public static Optional<Person> personOptional = Optional.of(getPerson());
    public static Person getPerson(){
        return new Person("A123", "Addi");
    }
}
