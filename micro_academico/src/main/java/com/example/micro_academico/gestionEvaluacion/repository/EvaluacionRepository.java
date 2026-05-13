package com.example.micro_academico.gestionEvaluacion.repository;

import com.example.micro_academico.gestionEvaluacion.model.entities.Evaluacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer> {
    
}
