package com.example.micro_academico.gestionAsignatura.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrarAsignaturaRequest {
    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    private String nombreAsignatura;

    @NotBlank(message = "Las horas semanales son obligatorias")
    private Integer horasSemanales;

    @NotBlank(message = "El nivel requerido es obligatorio")
    private String nivelRequerido;

    @NotBlank(message = "El ID del curso es obligatorio")
    private Integer idCurso;
}