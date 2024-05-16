package com.example.library.service;

import com.example.library.dto.ReaderDto;
import com.example.library.model.Reader;
import com.example.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderDto getReaderById(Long id) {
        Reader reader = readerRepository.findById(id).orElse(null);
        return ReaderDto.builder()
                .id(reader.getId())
                .number(reader.getNumber())
                .name(reader.getName())
                .build();
    }

    public ReaderDto getReaderByNumber(String number) {
        Reader reader = readerRepository.findByNumber(number);
        return ReaderDto.builder()
                .number(reader.getNumber())
                .name(reader.getName())
                .build();
    }

    public List<ReaderDto> getAllReaders() {
        List<Reader> readers = readerRepository.findAll();
        List<ReaderDto> readerDtos = new ArrayList<>();
        readers.forEach(e -> readerDtos.add(ReaderDto.builder()
                        .id(e.getId())
                    .number(e.getNumber())
                    .name(e.getName())
                    .build()));
        return readerDtos;
    }

    public void save(ReaderDto readerDto) {
        Reader reader = new Reader();
        reader.setNumber(readerDto.getNumber());
        reader.setName(readerDto.getName());
        readerRepository.save(reader);
    }

    public void delete(Long id) {
        readerRepository.deleteById(id);
    }

    public void changeReader(ReaderDto readerDto, Long id) {
        Reader reader = readerRepository.findById(id).orElse(null);
        reader.setNumber(readerDto.getNumber());
        reader.setName(readerDto.getName());
        readerRepository.save(reader);
    }
}
