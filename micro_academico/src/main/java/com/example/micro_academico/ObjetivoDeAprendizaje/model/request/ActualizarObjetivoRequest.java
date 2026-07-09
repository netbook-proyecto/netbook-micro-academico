package com.example.micro_academico.ObjetivoDeAprendizaje.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarObjetivoRequest {

    @NotBlank(message = "El código es obligatorio")
    private String codigo;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "El nivel es obligatorio")
    private String nivel;

    @NotNull(message = "El ID de la asignatura es obligatorio")
    private Integer idAsignatura;
}