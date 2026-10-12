package com.example.apitreino.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ExerciciosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;
}
