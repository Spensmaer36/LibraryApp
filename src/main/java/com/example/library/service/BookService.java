package com.example.library.service;

import com.example.library.dto.AuthorDto;
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
    private final AuthorService authorService;

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
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

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return BookDto.builder()
                .id(book.getId())
                .authorId(book.getAuthor().getId())
                .title(book.getTitle())
                .releaseDate(book.getReleaseYear())
                .description(book.getDescription())
                .build();
    }

    public void createBook(BookDto bookDto, AuthorDto authorDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(authorService.addAuthor(authorDto));
        book.getAuthor().setName(authorDto.getName());
        book.setReleaseYear(bookDto.getReleaseDate());
        book.setDescription(bookDto.getDescription());
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(BookDto bookDto, AuthorDto authorDto, Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        book.setTitle(bookDto.getTitle());
        book.setAuthor(authorService.addAuthor(authorDto));
        book.setReleaseYear(bookDto.getReleaseDate());
        book.setDescription(bookDto.getDescription());
        bookRepository.save(book);
    }
}
