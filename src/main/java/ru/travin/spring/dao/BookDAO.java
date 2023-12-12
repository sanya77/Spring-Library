package ru.travin.spring.dao;

import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;

import java.util.List;

public interface BookDAO {

    public List<Book> getAllBook();

    public Book getBook(int id);

    public void saveBook(Book book);

    public void updateBook(int id, Book book);

    public void deleteBook(int id);

    public Person getBookPerson(int id);

    public void deletePersonForBook(int id);
    public void addBookForPerson(int id, Person selectedPerson);

}
