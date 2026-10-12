package com.example.apitreino.service;

import com.example.apitreino.database.model.ExerciciosEntity;
import com.example.apitreino.database.repository.IExerciciosRepository;
import com.example.apitreino.dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicoService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public void save(ExerciciosDTO exerciciosDTO){
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exerciciosDTO.getNome())
                .grupoMuscular(exerciciosDTO.getGrupoMuscular())
                .build();
            exerciciosRepository.save(exercicio);
    }
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
