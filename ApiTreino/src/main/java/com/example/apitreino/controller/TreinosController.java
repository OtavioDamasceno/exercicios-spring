package com.example.apitreino.controller;

import com.example.apitreino.dto.TreinosDTO;
import com.example.apitreino.exception.BadRequestException;
import com.example.apitreino.exception.NotFoundException;
import com.example.apitreino.service.TreinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinosController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void criarTreino(@RequestBody TreinosDTO treinosDTO) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinosDTO);
    }
}
