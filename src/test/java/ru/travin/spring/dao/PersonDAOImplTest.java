package ru.travin.spring.dao;

import org.junit.jupiter.api.Test;

public class PersonDAOImplTest {
    private PersonDAOImpl personDAO;
    @Test
    public void shoudReturnPeople(){
    personDAO.getAllPerson();
    }
}
