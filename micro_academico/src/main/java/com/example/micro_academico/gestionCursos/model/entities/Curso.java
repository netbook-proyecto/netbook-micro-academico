package com.example.micro_academico.gestionCursos.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "letra_curso", length = 10, nullable = false)
    private String letraCurso;

    @Column(name = "anno_academico", nullable = false)
    private Integer annoAcademico;

    @Column(name = "jornada", length = 50, nullable = false)
    private String jornada;

    @Column(name = "cupos_maximos", nullable = false)
    private Integer cuposMaximos;
}