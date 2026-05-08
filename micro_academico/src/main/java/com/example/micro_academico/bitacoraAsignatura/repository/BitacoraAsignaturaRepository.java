package com.example.micro_academico.bitacoraAsignatura.repository;

import com.example.micro_academico.bitacoraAsignatura.model.entities.BitacoraAsignatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraAsignaturaRepository extends JpaRepository<BitacoraAsignatura, Long> {
    
}
