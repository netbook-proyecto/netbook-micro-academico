package com.example.micro_academico.gestionAsignatura.repository;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    // Busca todas las asignaturas 
    List<Asignatura> findByNivelRequerido(String nivelRequerido);

    // Busca las asignaturas por nombre 
    List<Asignatura> findByNombreAsignaturaContainingIgnoreCase(String nombreAsignatura);
    
}