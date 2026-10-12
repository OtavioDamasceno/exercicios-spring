package com.example.apitreino.controller;

import com.example.apitreino.database.model.AvaliacoesFisicasEntity;
import com.example.apitreino.dto.AlunoDTO;
import com.example.apitreino.exception.BadRequestException;
import com.example.apitreino.exception.NotFoundException;
import com.example.apitreino.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDTO alunoDTO) throws BadRequestException {
        alunoService.criarAluno(alunoDTO);
    }

    @GetMapping("/{alunoid}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAvaliacao(@PathVariable Integer alunoId) throws NotFoundException {
        return alunoService.getAlunoAvaliacao(alunoId);
    }
}
