package ru.travin.spring.dao;

import ru.travin.spring.entity.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> getAllBook();

    public Book getBook(int id);

    public void saveBook(Book book);

    public void updateBook(int id, Book book);

    public void deleteBook(int id);
}
