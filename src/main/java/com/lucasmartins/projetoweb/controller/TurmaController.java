package com.lucasmartins.projetoweb.controller;

import com.lucasmartins.projetoweb.controller.dto.TurmaDto;
import com.lucasmartins.projetoweb.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
@Tag(name = "Gerenciamento de Turmas", description = "Endpoints para operações com a entidade Turma, realizando o CRUD das turmas da instituição de ensino")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cadastrar uma nova turma, com os campos de nome, curso e período ",
            description = "Cria uma nova turma no sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Turma cadastrada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TurmaDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida (ex: nome em branco, curso não informado)",
                    content = @Content)
    })
    public TurmaDto cadastrarTurma(@RequestBody TurmaDto turmaDto) {
        return turmaService.cadastrarTurma(turmaDto);
    }


    @GetMapping("/{turmaId}")
    @ResponseStatus(code = HttpStatus.OK)
    public TurmaDto buscarTurmaPorId(@PathVariable int turmaId) {
        return turmaService.findById(turmaId);
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(code = HttpStatus.OK)
    public TurmaDto buscarTurmaPorNome(@PathVariable String nome) {
        return turmaService.findByNome(nome);
    }
}
