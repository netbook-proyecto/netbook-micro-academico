package com.example.micro_academico.gestionNotas.model.entities;
import lombok.Data;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro = new Date();

    //Lo siguiente puede ser opcional
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