package com.example.apitreino.database.repository;

import com.example.apitreino.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
    Optional<AlunosEntity> findByEmail(String email);
}
