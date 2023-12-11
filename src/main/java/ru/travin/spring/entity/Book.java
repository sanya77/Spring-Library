package ru.travin.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "namebook")
    private String nameBook;
    @Column(name = "author")
    private String author;
    @Column(name = "yearofbook")
    private int releaseBook;

    public Book(int id, String nameBook, String author, int releaseBook) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
        this.releaseBook = releaseBook;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseBook() {
        return releaseBook;
    }

    public void setReleaseBook(int releaseBook) {
        this.releaseBook = releaseBook;
    }
}
