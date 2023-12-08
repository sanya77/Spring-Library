package ru.travin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.travin.spring.entity.Person;

import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO{


    private final SessionFactory sessionFactory;
    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> getAllPerson(){
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Person order by id", Person.class).getResultList();
    }

    public Person getPerson(int id){
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }

    public void savePerson(Person person){
        Session session = sessionFactory.getCurrentSession();
        session.save(person);

    }
    public void updatePerson(int id, Person updateperson){
        Session session = sessionFactory.getCurrentSession();
        Person updatePerson = session.get(Person.class, id);

        updatePerson.setName(updateperson.getName());
        updatePerson.setSurname(updateperson.getSurname());
        updatePerson.setDepartment(updateperson.getDepartment());
        updatePerson.setSalary(updateperson.getSalary());


    }

    public void deletePerson(int id){
        Session session = sessionFactory.getCurrentSession();

        session.delete(session.get(Person.class, id));
    }

}
