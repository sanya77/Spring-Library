package ru.travin.spring.service;

import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;

import java.util.List;

public interface ServiceDAO {

    public List<Person> getAllPerson();
    public Person getPerson(int id);
    public void savePerson(Person person);
    public void updatePerson(int id, Person updateperson);
    public void deletePerson(int id);


    public List<Book> getAllBook();

    public Book getBook(int id);

    public void saveBook(Book book);

    public void updateBook(int id, Book book);

    public void deleteBook(int id);
}
