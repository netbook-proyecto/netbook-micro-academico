package com.example.micro_academico.gestionNotas.model.entities;

import lombok.Data;
import java.time.LocalDateTime; // IMPORTANTE: Usamos la librería moderna de tiempo

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @Column(name = "calificacion_obtenida", nullable = false)
    private Double calificacionObtenida;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    // Lo siguiente puede ser opcional
    @Column(name = "observacion_docente", nullable = true)
    private String observacionDocente;

    @Column(name = "estado_nota", nullable = false)
    private String estadoNota;

    public void setIdEstudiante(Long idEstudiante) {
        throw new UnsupportedOperationException("Unimplemented method 'setIdEstudiante'");
    }

    public void setIdAsignatura(Long idAsignatura) {
        throw new UnsupportedOperationException("Unimplemented method 'setIdAsignatura'");
    }
}