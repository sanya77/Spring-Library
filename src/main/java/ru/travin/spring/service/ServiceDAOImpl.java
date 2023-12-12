package ru.travin.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.travin.spring.dao.BookDAO;
import ru.travin.spring.dao.PersonDAO;
import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;

import java.util.List;

@Service
public class ServiceDAOImpl implements ServiceDAO {

    private PersonDAO personDAO;
    private BookDAO bookDAO;

    @Autowired
    public ServiceDAOImpl(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    @Override
    @Transactional
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(int id, Person updateperson) {
        personDAO.updatePerson(id, updateperson);
    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        personDAO.deletePerson(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBook() {
        return bookDAO.getAllBook();
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public void updateBook(int id, Book book) {
        bookDAO.updateBook(id, book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }


    @Override
    @Transactional
    public List<Book> getBookIdPerson(int id) {
        return personDAO.getBookIdPerson(id);
    }
}
