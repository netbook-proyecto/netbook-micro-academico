package com.example.micro_academico.gestionCursos.repository;   

import com.example.micro_academico.gestionCursos.model.entities.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
}