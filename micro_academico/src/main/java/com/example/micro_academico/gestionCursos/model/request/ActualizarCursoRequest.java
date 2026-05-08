package com.example.micro_academico.gestionCursos.model.request;

import lombok.Data;

@Data
public class ActualizarCursoRequest {
    private String letraCurso;
    private Integer annoAcademico;
    private String jornada;
    private Integer cuposMaximos;
}