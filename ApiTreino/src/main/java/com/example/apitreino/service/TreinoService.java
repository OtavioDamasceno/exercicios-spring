package com.example.apitreino.service;

import com.example.apitreino.database.model.AlunosEntity;
import com.example.apitreino.database.model.ExerciciosEntity;
import com.example.apitreino.database.model.TreinosEntity;
import com.example.apitreino.database.repository.IAlunosRepository;
import com.example.apitreino.database.repository.IExerciciosRepository;
import com.example.apitreino.database.repository.ITreinosRepository;
import com.example.apitreino.dto.TreinosDTO;
import com.example.apitreino.exception.BadRequestException;
import com.example.apitreino.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {
    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinosDTO treinosDTO) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinosDTO.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));


        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinosDTO.getNome(),
                        treinosDTO.getAlunoId())
                .orElse(null);
        if (treino != null) {
            throw new BadRequestException("esse aluno ja possui um treino com esse nome");
        }
        for (Integer exercicioId : treinosDTO.getExerciciosIds()) {
            {
                ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                        .orElseThrow(() -> new NotFoundException("Exercicio nao encontrado"));
                exercicios.add(exercicio);
            }

        treino = TreinosEntity.builder()
                .nome(treinosDTO.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

            treinosRepository.save(treino);
        }
    }
}
