package com.example.micro_academico.gestionNotas.model.entities;

import lombok.Data;
import java.time.LocalDateTime;

import com.example.micro_academico.gestionEvaluacion.model.entities.Evaluacion;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer idNota;

    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;

    @Column(name = "id_asignatura", nullable = false)
    private Integer idAsignatura;

    @Column(name = "calificacion_obtenida", nullable = false)
    private Double calificacionObtenida;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "observacion_docente", nullable = true)
    private String observacionDocente;

    @Column(name = "estado_nota", nullable = false)
    private String estadoNota = "ACTIVA";
    
    @ManyToOne
    @JoinColumn(name = "id_evaluacion", nullable = false)
    private Evaluacion evaluacion;

}