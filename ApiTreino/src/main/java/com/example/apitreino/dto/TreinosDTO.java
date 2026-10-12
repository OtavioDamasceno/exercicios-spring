package com.example.apitreino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TreinosDTO {
    @NotBlank
    private Integer alunoId;
    @NotBlank
    private String nome;
    @NotEmpty
    private List<Integer> exerciciosIds;
}
