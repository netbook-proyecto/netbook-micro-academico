package com.example.micro_academico.gestionCursos.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer idSala;

    @Column(name = "nombre_sala", nullable = false)
    private String nombreSala;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
}
