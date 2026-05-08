package com.example.micro_academico.gestionAsignatura.repository;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
}