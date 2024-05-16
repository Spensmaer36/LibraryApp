package com.example.library.controller;

import com.example.library.dto.AuthorDto;
import com.example.library.dto.BookDto;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("author", authorService);
        return "book/index";
    }

    @GetMapping("create")
    public String create() {
        return "book/create";
    }

    @PostMapping("create")
    public String create(BookDto bookDto, AuthorDto authorDto) {
        bookService.createBook(bookDto, authorDto);
        return "redirect:/book";
    }
}
