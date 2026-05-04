package com.example.micro_academico.gestionAsignatura.service;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> obtenerTodasLasAsignaturas() {
        return asignaturaRepository.findAll();
    }

    //Para obetene las asignaturas por su id
    public Asignatura obtenerAsignaturaPorId(Long idAsignatura) {
        
        return asignaturaRepository.findById(idAsignatura).orElse(null);
    }

    public Asignatura registrarAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public void eliminarAsignatura(Long idAsignatura) {
        asignaturaRepository.deleteById(idAsignatura);
    }
}