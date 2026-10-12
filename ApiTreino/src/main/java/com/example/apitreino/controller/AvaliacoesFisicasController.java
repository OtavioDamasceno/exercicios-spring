package com.example.apitreino.controller;

import com.example.apitreino.dto.AvaliacaoFisicaDTO;
import com.example.apitreino.exception.BadRequestException;
import com.example.apitreino.exception.NotFoundException;
import com.example.apitreino.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDTO);
    }
}
