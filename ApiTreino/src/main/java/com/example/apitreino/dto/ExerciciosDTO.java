package com.example.apitreino.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class ExerciciosDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
