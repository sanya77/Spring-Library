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


@Controller
@RequestMapping("/book")
public class BookController {


    private ServiceDAO serviceDAO;

    @Autowired
    public BookController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GetMapping
    public String getAllBook(Model model) {

        model.addAttribute("allBook", serviceDAO.getAllBook());
        return "book/all-book";
    }

    @GetMapping("{id}")
    public String getBook(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {

        model.addAttribute("book", serviceDAO.getBook(id));
        Person bookPerson = serviceDAO.getBookPerson(id);
        if (bookPerson == null) {
            model.addAttribute("AllPeople", serviceDAO.getAllPerson());
        }
        model.addAttribute("bookPerson", serviceDAO.getBookPerson(id));

        return "book/show-book";
    }

    @GetMapping("/newBook")
    public String newbook(@ModelAttribute("book") Book book) {
        return "book/new-book";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "book/new-book";
        }
        serviceDAO.saveBook(book);

        return "redirect:/book";
    }

    @GetMapping("/{id}/editBook")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("editBook", serviceDAO.getBook(id));
        return "book/edit-book";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("editBook") Book book, @PathVariable("id") int id) {
        serviceDAO.updateBook(id, book);

        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        serviceDAO.deleteBook(id);
        return "redirect:/book";
    }

    // удаляет книгу с человека
    @PatchMapping("/{id}/deletePersonForBook")
    public String deletePersonForBook(@PathVariable("id") int id) {
        serviceDAO.deletePersonForBook(id);
        return "redirect:/book/" + id;
    }

    // назначает книгу для человека
    @PatchMapping("/{id}/addBookForPerson")
    public String addBookForPerson(@PathVariable("id") int id, @ModelAttribute("person") Person selectedPerson) {
        serviceDAO.addBookForPerson(id, selectedPerson);
        return "redirect:/book/" + id;
    }
}

