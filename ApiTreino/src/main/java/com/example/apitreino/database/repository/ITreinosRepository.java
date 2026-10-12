package com.example.apitreino.database.repository;

import com.example.apitreino.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer alunoId);
}
