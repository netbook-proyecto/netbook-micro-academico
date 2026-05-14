package com.example.micro_academico.gestionCursos.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarCursoRequest {

    @NotBlank(message = "La letra del curso es obligatoria")
    private String letraCurso;

    @NotBlank(message = "El año académico es obligatorio")
    private Integer annoAcademico;

    @NotBlank(message = "La jornada es obligatoria")
    private String jornada;
    
    @NotBlank(message = "Los cupos máximos son obligatorios")
    private Integer cuposMaximos;
}