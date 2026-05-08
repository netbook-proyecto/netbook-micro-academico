package com.example.micro_academico.gestionCursos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "letra_curso", length = 10)
    private String letraCurso;

    @Column(name = "anno_academico")
    private Integer annoAcademico;

    @Column(name = "jornada", length = 50)
    private String jornada;

    @Column(name = "cupos_maximos")
    private Integer cuposMaximos;
}