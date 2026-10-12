package com.example.apitreino.controller;

import com.example.apitreino.database.model.ExerciciosEntity;
import com.example.apitreino.dto.ExerciciosDTO;
import com.example.apitreino.service.ExercicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {

    private final ExercicoService exercicoService;

    //gets
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll() {
        return exercicoService.findAll();
    }

    @GetMapping("/grupos/{grupomuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular) {
        return exercicoService.getExerciciosByGrupoMuscular(grupoMuscular);
    }

    //posts
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExerciciosDTO exerciciosDTO) {
        exercicoService.save(exerciciosDTO);
    }
}
