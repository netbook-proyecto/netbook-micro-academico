package com.example.micro_academico.gestionCursos.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nivel")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_nivel")
    private Integer idNivel;

    @Column(name = "nombre_nivel", nullable = false)
    private String nombreNivel;
}
