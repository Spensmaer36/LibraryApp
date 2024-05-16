package com.example.library.controller;

import com.example.library.service.AuthorService;
import com.example.library.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    private final AuthorService authorService;

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("searchResults", searchService.search(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("author", authorService);
        return "search/index";
    }
}
