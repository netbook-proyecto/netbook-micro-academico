package com.example.micro_academico.gestionNotas.model.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
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

    
}