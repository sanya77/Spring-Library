package ru.travin.spring.entity;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
@FetchProfile(name = "withBook", fetchOverrides = {
        @FetchProfile.FetchOverride(entity = Person.class, association = "books", mode = FetchMode.JOIN)
})

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 2, message = "Минимальная длина имени 2 символа")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 2, message = "Минимальная длина фамилии 2 символа")
    private String surname;
    @Column(name = "age")
    @Min(value = 16, message = "Минимальный возраст читателя 16 лет")
    private int age;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "person")
    public List<Book> books;

    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;

    }


    public Person() {
    }

    public void addBookPerson(Book book){
        if(books == null){
            books = new ArrayList<>();
        }
        books.add(book);
        book.setPerson(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }




}
