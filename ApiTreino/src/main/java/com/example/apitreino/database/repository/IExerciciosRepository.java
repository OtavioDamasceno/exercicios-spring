package com.example.apitreino.database.repository;

import com.example.apitreino.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

    public List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

}
