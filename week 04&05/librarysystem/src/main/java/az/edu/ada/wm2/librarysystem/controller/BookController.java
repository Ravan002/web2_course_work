package az.edu.ada.wm2.librarysystem.controller;

import az.edu.ada.wm2.librarysystem.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final List<Book> books;

    public BookController() {

        books = new ArrayList<>();
        books.add(new Book(1, "Book 1", "Description 1", 2020, "Author 1"));
        books.add(new Book(2, "Book 2", "Description 2", 2018, "Author 2"));
        books.add(new Book(3, "Book 3", "Description 3", 2015, "Author 3"));
    }
    @GetMapping("/")
    public String listBooks(Model model) {
        model.addAttribute("books", books);
        return "book/listBooks";
    }

    @GetMapping("/create")
    public String createBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/createBook";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        books.add(book);
        return "redirect:/books/";
    }
}
