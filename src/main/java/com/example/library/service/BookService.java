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
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(e-> {bookDtos.add(BookDto.builder()
                        .id(e.getId())
                        .authorId(e.getAuthor().getId())
                        .name(e.getName())
                        .stateId(e.getState().getId())
                        .releaseDate(e.getReleaseYear())
                        .description(e.getDescription())
                .build());});
        return bookDtos;
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return BookDto.builder()
                .id(book.getId())
                .authorId(book.getAuthor().getId())
                .name(book.getName())
                .stateId(book.getState().getId())
                .releaseDate(book.getReleaseYear())
                .description(book.getDescription())
                .build();
    }
}
