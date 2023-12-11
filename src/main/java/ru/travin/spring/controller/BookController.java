package ru.travin.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.travin.spring.entity.Book;
import ru.travin.spring.entity.Person;
import ru.travin.spring.service.ServiceDAO;

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
    public String getBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", serviceDAO.getBook(id));
//        Optional<Person> bookOwner = serviceDAO.getBookOwner(id);
        return "book/show-book";
    }

    @GetMapping("/newBook")
    public String newbook(@ModelAttribute("book") Book book) {
        return "book/new-book";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) {
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
    public String deleteBook(@PathVariable("id") int id){
        serviceDAO.deleteBook(id);
        return "redirect:/book";
    }
}

