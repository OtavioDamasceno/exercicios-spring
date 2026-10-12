package com.example.apitreino.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;

}
