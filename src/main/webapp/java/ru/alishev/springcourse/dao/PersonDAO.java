package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int ID;
    private List<Person> people;

    {
      people = new ArrayList<>();

      people.add(new Person(++ID, "Tomas"));
      people.add(new Person(++ID, "Petr"));
      people.add(new Person(++ID, "Igor"));
      people.add(new Person(++ID, "Ivan"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++ID);
        people.add(person);
    }
}
