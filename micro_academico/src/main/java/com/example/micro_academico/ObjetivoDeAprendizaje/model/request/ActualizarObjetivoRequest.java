package com.example.micro_academico.ObjetivoDeAprendizaje.model.request;

import lombok.Data;

@Data
public class ActualizarObjetivoRequest {
    private String codigo;
    private String descripcion;
    private String asignatura;
    private String nivel;
}
