package com.example.library.controller;

import com.example.library.service.BookService;
import com.example.library.service.JournalService;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("journal")
@RequiredArgsConstructor
public class JournalController {
    private final JournalService journalService;
    private final BookService bookService;
    private final ReaderService readerService;

    @GetMapping
    public String getJournals(Model model) {
        model.addAttribute("journals", journalService.getAllJournals());
        model.addAttribute("books", bookService);
        model.addAttribute("readers", readerService);
        return "journal/index";
    }

}
