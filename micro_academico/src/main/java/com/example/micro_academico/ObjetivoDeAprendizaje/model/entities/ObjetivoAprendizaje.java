package com.example.micro_academico.ObjetivoDeAprendizaje.model.entities;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "objetivos_aprendizaje")
public class ObjetivoAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivo")
    private Integer idObjetivo;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "nivel", nullable = false, length = 50)
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;
}