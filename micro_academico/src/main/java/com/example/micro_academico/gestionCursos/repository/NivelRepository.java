package com.example.micro_academico.gestionCursos.repository;

import com.example.micro_academico.gestionCursos.model.entities.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Integer> {
    
}
