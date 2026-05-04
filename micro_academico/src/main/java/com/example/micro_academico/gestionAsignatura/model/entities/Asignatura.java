package com.example.micro_academico.gestionAsignatura.model.entities;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "Asignatura")

public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_asignatura")
    private Long idAsigantura;

    @Column(name = "nombre_asignatura", nullable = false)
    private String nombreAsigantura;

    @Column(name = "horas_semanales", nullable = false)
    private Integer horaSemanales;

    @Column(name = "nivel_requerido", nullable = false)
    private String nivelRequerido;

}
