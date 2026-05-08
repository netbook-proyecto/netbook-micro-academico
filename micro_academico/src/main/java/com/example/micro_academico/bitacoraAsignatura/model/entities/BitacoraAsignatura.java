package com.example.micro_academico.bitacoraAsignatura.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "bitacora_asignatura")

public class BitacoraAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_bitacora_asignatura")
    private Long idBitacoraAsignatura;
    
    @Column(name="fecha_clase", nullable = false)
    private LocalDate fechaClase;

    @Column(name="actividades_realizadas", nullable = false)
    private String actividadesRealizadas;

    @Column(name="contenidos_tratados", nullable = false)
    private String contenidosTratados;

    @Column(name="observaciones_generales", nullable = true)
    private String observacionesGenerales;
}
