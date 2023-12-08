package ru.travin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.travin.spring.entity.Book;

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
}
