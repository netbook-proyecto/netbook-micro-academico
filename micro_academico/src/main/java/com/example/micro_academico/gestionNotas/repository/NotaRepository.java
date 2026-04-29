package com.example.micro_academico.gestionNotas.repository;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

    
}