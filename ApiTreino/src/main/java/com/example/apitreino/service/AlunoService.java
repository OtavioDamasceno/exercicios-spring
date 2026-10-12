package com.example.apitreino.service;

import com.example.apitreino.database.model.AlunosEntity;
import com.example.apitreino.database.model.AvaliacoesFisicasEntity;
import com.example.apitreino.database.repository.IAlunosRepository;
import com.example.apitreino.dto.AlunoDTO;
import com.example.apitreino.exception.BadRequestException;
import com.example.apitreino.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private static IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDTO alunoDTO) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDTO.getEmail())
                .orElseThrow(null);

        if (aluno != null) {
            throw new BadRequestException("aluno ja cadastrado");
        }
        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDTO.getNome())
                .email(aluno.getEmail())
                .build());
    }

    public AvaliacoesFisicasEntity getAlunoAvaliacao(Integer alunoId) throws NotFoundException {
       AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado!"));

       AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
       if(avaliacaoFisica == null){
           throw new NotFoundException("Avaliacao fisica nao encontrada neste aluno");
       }
       return avaliacaoFisica;
    }
}
