package com.example.apitreino.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AlunosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToOne
    @JoinColumn(name = "avaliacao_fisica_id")
    private AvaliacoesFisicasEntity avaliacaoFisica;
    @OneToMany(mappedBy = "aluno")
    private Set<TreinosEntity> treinos = new HashSet<>();
}
