package com.example.library.service;

import com.example.library.dto.BookDto;
import com.example.library.dto.JournalDto;
import com.example.library.model.Journal;
import com.example.library.repository.BookRepository;
import com.example.library.repository.JournalRepository;
import com.example.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JournalService {
    private final JournalRepository journalRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    public List<JournalDto> getAllJournals() {
        List<Journal> journals = journalRepository.findAll();
        List<JournalDto> journalDtos = new ArrayList<>();
        journals.forEach(e -> {journalDtos.add(JournalDto.builder()
                        .id(e.getId())
                        .bookId(e.getBook().getId())
                        .readerId(e.getReader().getId())
                .build());});
        return journalDtos;
    }

    public void addJournal(JournalDto journalDto, Long bookId, String num) {
        Journal journal = new Journal();
        journal.setBook(bookRepository.findById(bookId).orElse(null));
        journal.setReader(readerRepository.findByNumber(num));
    }

}
