package com.example.micro_academico.gestionNotas.model.entities;

import lombok.Data;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @Column(name = "id_estudiante", nullable = false)
    private Long idEstudiante;

    @Column(name = "id_asignatura", nullable = false)
    private Long idAsignatura;

    @Column(name = "calificacion_obtenida", nullable = false)
    private Double calificacionObtenida;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "observacion_docente", nullable = true)
    private String observacionDocente;

    @Column(name = "estado_nota", nullable = false)
    private String estadoNota = "ACTIVA"; 
}