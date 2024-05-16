package com.example.library.controller;

import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("author", authorService);
        return "main/main";
    }
}
