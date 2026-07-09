package com.example.micro_academico.gestionEvaluacion.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RegistrarEvaluacionRequest {

    @NotNull(message = "El valor de la nota es obligatorio")
    private Double valorNota;

    @NotNull(message = "La ponderación es obligatoria")
    private Integer ponderacionPorcentaje;

    @NotNull(message = "La fecha de evaluación es obligatoria")
    private LocalDate fechaEvaluacion;

    @NotBlank(message = "El tipo de evaluación es obligatorio")
    private String tipoEvaluacion;

    @NotNull(message = "El ID de la asignatura es obligatorio")
    private Integer idAsignatura;
}