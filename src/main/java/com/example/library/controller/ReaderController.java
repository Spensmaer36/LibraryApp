package com.example.library.controller;

import com.example.library.dto.ReaderDto;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping("/reader")
    public String getReaders(Model model){
        model.addAttribute("readers", readerService.getAllReaders());
        return "reader/index";
    }

    @GetMapping("reader/create")
    public String create(){
        return "reader/create";
    }

    @PostMapping("reader/create")
    public String editReader(ReaderDto readerDto){
        readerService.save(readerDto);
        return "redirect:/reader";
    }

    @GetMapping("reader/delete/{id}")
    public String deleteReader(@PathVariable Long id){
        readerService.delete(id);
        return "redirect:/reader";
    }

    @GetMapping("reader/update/{id}")
    public String updateReader(@PathVariable Long id, Model model){
        model.addAttribute("reader", readerService.getReaderById(id));
        return "reader/update";
    }

    @PostMapping("reader/update/{id}")
    public String updateReader(@PathVariable Long id, ReaderDto readerDto){
        readerService.changeReader(readerDto, id);
        return "redirect:/reader";
    }
}
