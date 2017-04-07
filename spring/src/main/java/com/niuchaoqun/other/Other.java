package com.niuchaoqun.other;

import com.niuchaoqun.config.Person;
import org.springframework.beans.factory.annotation.Autowired;

public class Other {
    public Person person;

    @Override
    public String toString() {
        return "Other{}";
    }

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }
}
