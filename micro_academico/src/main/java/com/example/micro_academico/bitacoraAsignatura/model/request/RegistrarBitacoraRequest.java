package com.example.micro_academico.bitacoraAsignatura.model.request;

import lombok.Data;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

@Data
public class RegistrarBitacoraRequest {
    @NotNull(message = "La fecha de la clase es obligatoria")
    private LocalDate fechaClase;

    @NotNull(message = "Las actividades realizadas son obligatorias")
    private String actividadesRealizadas;
    
    @NotNull(message = "Los contenidos tratados son obligatorios")
    private String contenidosTratados;

    @NotNull(message = "Las observaciones generales son obligatorias")
    private String observacionesGenerales;

    @NotNull(message = "El ID de la asignatura es obligatorio")
    private Integer idAsignatura;
}
