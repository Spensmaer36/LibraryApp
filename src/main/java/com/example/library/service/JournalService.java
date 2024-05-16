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

    public void addJournal(JournalDto journalDto) {
        Journal journal = new Journal();
        journal.setBook(bookRepository.findById(journalDto.getBookId()).orElseThrow(null));
        journal.setReader(readerRepository.findById(journalDto.getReaderId()).orElseThrow(null));
        journalRepository.save(journal);
    }

    public void deleteJournal(Long id) {
        journalRepository.deleteById(id);
    }

    public void changeJournal(JournalDto journalDto, Long id) {
        Journal journal = journalRepository.findById(id).orElseThrow(null);
        journal.setBook(bookRepository.findById(journalDto.getBookId()).orElseThrow(null));
        journal.setReader(readerRepository.findById(journalDto.getReaderId()).orElseThrow(null));
        journalRepository.save(journal);
    }

    public JournalDto getById(Long id) {
        Journal journal = journalRepository.findById(id).orElseThrow(null);
        return JournalDto.builder()
                .id(journal.getId())
                .bookId(journal.getBook().getId())
                .readerId(journal.getReader().getId())
                .build();
    }
}
