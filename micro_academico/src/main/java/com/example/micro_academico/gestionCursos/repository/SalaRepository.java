package com.example.micro_academico.gestionCursos.repository;

import com.example.micro_academico.gestionCursos.model.entities.Sala;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
    
}
