package com.example.micro_academico.gestionAsignatura.model.request;

import lombok.Data;

@Data
public class RegistrarAsignaturaRequest {
    private int idAsignatura;
    private String nombreAsignatura;
    private Integer horasSemanales;
    private String nivelRequerido;
}
