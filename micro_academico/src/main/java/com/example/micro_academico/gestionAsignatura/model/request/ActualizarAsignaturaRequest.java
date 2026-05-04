package com.example.micro_academico.gestionAsignatura.model.request;

import lombok.Data;

@Data
public class ActualizarAsignaturaRequest {
    private String nombreAsignatura;
    private Integer horasSemanales;
    private String nivelRequerido;
}
