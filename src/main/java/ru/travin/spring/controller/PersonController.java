package ru.travin.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;
import ru.travin.spring.service.ServiceDAO;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    private ServiceDAO serviceDAO;
    @Autowired
    public PersonController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GetMapping("/all")
    public String getAllPerson(Model model){

        model.addAttribute("AllPeople", serviceDAO.getAllPerson());

        return "person/all-person";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", serviceDAO.getPerson(id));
        model.addAttribute("books", serviceDAO.getBookIdPerson(id));
        return "person/show-person";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "person/people-new";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "person/people-new";
        }
    serviceDAO.savePerson(person);
    return "redirect:/people/all";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")  int id, Model model){

        model.addAttribute("person", serviceDAO.getPerson(id));
        return "person/edit-people";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "person/edit-people";
        }
        serviceDAO.updatePerson(id,person);
        return "redirect:/people/all";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id){
        serviceDAO.deletePerson(id);
        return "redirect:/people/all";

    }


}
