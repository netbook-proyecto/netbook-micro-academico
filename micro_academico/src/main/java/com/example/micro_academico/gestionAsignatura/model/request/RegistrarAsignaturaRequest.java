package com.example.micro_academico.gestionAsignatura.model.request;

import lombok.Data;

@Data
public class RegistrarAsignaturaRequest {
    private Long idAsignatura;
    private String nombreAsignatura;
    private Integer horasSemanales;
    private String niverRequerido;
}
