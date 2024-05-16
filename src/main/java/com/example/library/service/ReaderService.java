package com.example.library.service;

import com.example.library.dto.ReaderDto;
import com.example.library.model.Reader;
import com.example.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderDto getReaderByNumber(String number) {
        Reader reader = readerRepository.findByNumber(number);
        return ReaderDto.builder()
                .number(reader.getNumber())
                .name(reader.getName())
                .build();
    }
}
