package ru.travin.spring.entity;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    @Column(name = "releasebook")
    private int releaseBook;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public List<Book> setPerson(Person person) {
        this.person = person;
        return null;
    }

}
