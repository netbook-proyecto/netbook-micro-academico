package com.example.micro_academico.ObjetivoDeAprendizaje.model.request;

import lombok.Data;

@Data
public class RegistrarObjetivoRequest {
    private String codigo;
    private String descripcion; 
    private String asignatura;
    private String nivel;
}
