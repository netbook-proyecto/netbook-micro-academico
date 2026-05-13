package com.example.micro_academico.gestionEvaluacion.model.entities;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionNotas.model.entities.Nota;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "evaluaciones")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;

    @Column(name = "valor_nota", nullable = false)
    private Double valorNota;

    @Column(name = "ponderacion_porcentaje", nullable = false)
    private Integer ponderacionPorcentaje;

    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    @Column(name = "tipo_evaluacion", nullable = false)
    private String tipoEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL)
    private List<Nota> notas;

}
