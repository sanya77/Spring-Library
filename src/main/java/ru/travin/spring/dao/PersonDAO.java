package ru.travin.spring.dao;

import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> getAllPerson();
    public Person getPerson(int id);
    public void savePerson(Person person);
    public void updatePerson(int id, Person updateperson);
    public void deletePerson(int id);
//    public void testNPlus1();

    public List<Book> getBookIdPerson(int id);
}
