package com.example.micro_academico.gestionNotas.model.request;
import lombok.Data;

@Data
public class RegistrarNotaRequest {
    private Long idEstudiante;
    private Long idAsignatura;
    private Double calificacionObtenida;
    private String observacionDocente;
}
