package com.example.micro_academico.ObjetivoDeAprendizaje.repository;

import com.example.micro_academico.ObjetivoDeAprendizaje.model.entities.ObjetivoAprendizaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoAprendizajeRepository extends JpaRepository<ObjetivoAprendizaje, Integer> {
}