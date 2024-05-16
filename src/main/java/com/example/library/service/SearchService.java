package com.example.library.service;

import com.example.library.dto.BookDto;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {
    private final BookRepository bookRepository;

    public List<BookDto> search(String search) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(search);
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(e-> {bookDtos.add(BookDto.builder()
                .id(e.getId())
                .authorId(e.getAuthor().getId())
                .title(e.getTitle())
                .releaseDate(e.getReleaseYear())
                .description(e.getDescription())
                .build());});
        return bookDtos;
    }
}
