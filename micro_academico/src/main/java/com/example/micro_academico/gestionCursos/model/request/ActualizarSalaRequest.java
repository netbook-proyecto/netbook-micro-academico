package com.example.micro_academico.gestionCursos.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarSalaRequest {

    @NotBlank(message = "El nombre de la sala es obligatorio")
    private String nombreSala;

    @NotNull(message = "La capacidad de la sala es obligatoria")
    private Integer capacidad;
}
