package com.example.micro_academico.gestionNotas.model.request;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarNotaRequest {
    
    private Integer idAsignatura;
    private Double calificacionObtenida;
    private String observacionDocente;

    @NotNull(message = "El ID de la evaluación es obligatorio")
    private Integer idEvaluacion;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer idEstudiante;
}
