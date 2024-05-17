package com.example.library.service;

import com.example.library.dto.AuthorDto;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }

    public Author addAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        authorRepository.save(author);
        return author;
    }

    public Author findAuthorByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    public AuthorDto checkAuthor(AuthorDto authorDto) {
        if(authorRepository.findByNameContainingIgnoreCase(authorDto.getName()) == null){
            return null;
        }else {
            Author author = authorRepository.findByNameContainingIgnoreCase(authorDto.getName());
            return AuthorDto.builder()
                    .id(author.getId())
                    .name(author.getName())
                    .build();
        }
    }
}
