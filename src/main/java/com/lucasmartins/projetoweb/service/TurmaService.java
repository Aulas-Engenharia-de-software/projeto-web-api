package com.lucasmartins.projetoweb.service;

import com.lucasmartins.projetoweb.controller.dto.TurmaDto;
import com.lucasmartins.projetoweb.model.repository.TurmaRepository;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaDto cadastrarTurma(TurmaDto turmaDto) {
        return turmaRepository.save(turmaDto);
    }

    public TurmaDto findById(int turmaId) {
        return turmaRepository.findById(turmaId);
    }
}
