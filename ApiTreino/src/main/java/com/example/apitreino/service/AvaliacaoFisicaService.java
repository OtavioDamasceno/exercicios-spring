package com.example.apitreino.service;

import com.example.apitreino.database.model.AlunosEntity;
import com.example.apitreino.database.model.AvaliacoesFisicasEntity;
import com.example.apitreino.database.repository.IAlunosRepository;
import com.example.apitreino.database.repository.IAvaliacoesFisicasRepository;
import com.example.apitreino.dto.AvaliacaoFisicaDTO;
import com.example.apitreino.exception.BadRequestException;
import com.example.apitreino.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;
    private final IAlunosRepository alunosRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDTO.getAlunoId())
                .orElseThrow(() -> new NotFoundException("aluno nao encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisicas = aluno.getAvaliacaoFisica();

        if (avaliacoesFisicas != null) {
            throw new BadRequestException("Avaliacao fisica já cadastrada para esse aluno");
        }
        avaliacoesFisicas = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDTO.getPeso())
                .altura(avaliacaoFisicaDTO.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDTO.getPercentualGorduraCorporal())
                .build();

        avaliacoesFisicas = avaliacoesFisicasRepository.save(avaliacoesFisicas);
        aluno.setAvaliacaoFisica(avaliacoesFisicas);
        alunosRepository.save(aluno);
    }
}
