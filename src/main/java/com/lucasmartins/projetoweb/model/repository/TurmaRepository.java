package com.lucasmartins.projetoweb.model.repository;

import com.lucasmartins.projetoweb.controller.dto.TurmaDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepository {

    final List<TurmaDto> turmas = new ArrayList<>();

    public TurmaDto save(TurmaDto turmaDto) {
        turmaDto.setId(turmas.size() + 1);
        turmas.add(turmaDto);
        return turmaDto;
    }

    public TurmaDto findById(int turmaId) {
        for (TurmaDto turma : turmas) {
            if (turma.getId() == turmaId) {
                return turma;
            }
        }
        throw new RuntimeException("Turma não encontrada com o ID: " + turmaId);
    }


}
