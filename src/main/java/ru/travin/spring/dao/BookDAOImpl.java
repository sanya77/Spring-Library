package ru.travin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;

import java.util.List;

@Component
public class BookDAOImpl implements BookDAO{

    private final SessionFactory sessionFactory;
    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // получаем список всех книг
    @Override
    public List<Book> getAllBook() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book order by id", Book.class).getResultList();
    }

    @Override
    public Book getBook(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class, id);
    }

    @Override
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);

    }

    @Override
    public void updateBook(int id, Book updatebook) {
    Session session = sessionFactory.getCurrentSession();

    Book updateBooks = session.get(Book.class, id);

    updateBooks.setNameBook(updatebook.getNameBook());
    updateBooks.setAuthor(updatebook.getAuthor());
    updateBooks.setReleaseBook(updatebook.getReleaseBook());
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(session.get(Book.class,id));

    }

    public Person getBookPerson(int id){
        Session session = sessionFactory.getCurrentSession();
        session.enableFetchProfile("withPerson");

        Book book = session.get(Book.class, id);
        return book.getPerson();
    }
    // удаляет книгу с человека
    public void deletePersonForBook(int id){
        Session session = sessionFactory.getCurrentSession();
        Query update = session.createQuery("update Book b SET b.person.id = ?1 where b.id = ?2");
        update.setParameter(1,null); // назначаем id человека null, чтобы снять его с книги
        update.setParameter(2,id); // делаем это для id книги, которая пришла
        update.executeUpdate();

    }
    // назначает книгу на человека
    public void addBookForPerson(int id, Person selectedPerson){
        Session session = sessionFactory.getCurrentSession();
        Query update = session.createQuery("UPDATE Book b SET b.person.id= ?1 where b.id = ?2");
        update.setParameter(1, selectedPerson.getId()); // назначаем id человека, который взял книгу
        update.setParameter(2, id); // назначаем id книги
        update.executeUpdate();
    }
}
