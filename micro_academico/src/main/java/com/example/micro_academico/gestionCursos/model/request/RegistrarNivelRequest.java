package com.example.micro_academico.gestionCursos.model.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class RegistrarNivelRequest {

    @NotBlank(message = "El nombre del nivel es obligatorio")
    private String nombreNivel;
    
}
