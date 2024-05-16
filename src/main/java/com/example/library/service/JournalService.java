package com.example.library.service;

import com.example.library.dto.JournalDto;
import com.example.library.model.Journal;
import com.example.library.repository.JournalRepository;
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
}
