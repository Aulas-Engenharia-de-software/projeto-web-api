package com.lucasmartins.projetoweb.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
@Tag(name = "Gerenciamento de Alunos", description = "Endpoints para operações com a entidade Aluno, realizando o CRUD aos alunos da instituição de ensino")
public class AlunoController {

    @GetMapping
    public String buscarAluno() {
        return "Lucas";
    }
}
