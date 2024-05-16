package com.example.library.service;

import com.example.library.dto.StateDto;
import com.example.library.model.State;
import com.example.library.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;

    public StateDto getStateDtoById(Long id) {
        State state = stateRepository.findById(id).orElse(null);
        return StateDto.builder()
                .id(state.getId())
                .state(state.getState())
                .build();
    }
}
