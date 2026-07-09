package com.example.micro_academico.gestionCursos.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarCursoRequest {

    @NotNull(message = "La letra del curso es obligatoria")
    private String letraCurso;

    @NotNull(message = "El año académico es obligatorio")
    private Integer annoAcademico;

    @NotNull(message = "La jornada es obligatoria")
    private String jornada;

    @NotNull(message = "Los cupos máximos son obligatorios")
    private Integer cuposMaximos;
}