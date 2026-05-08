package com.example.micro_academico.ObjetivoDeAprendizaje.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "objetivos_aprendizaje")
public class ObjetivoAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivo")
    private Long idObjetivo;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "asignatura", nullable = false, length = 100)
    private String asignatura;

    @Column(name = "nivel", nullable = false, length = 50)
    private String nivel;
}