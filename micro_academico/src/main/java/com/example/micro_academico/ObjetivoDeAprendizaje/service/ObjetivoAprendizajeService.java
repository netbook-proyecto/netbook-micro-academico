package com.example.micro_academico.ObjetivoDeAprendizaje.service;

import com.example.micro_academico.ObjetivoDeAprendizaje.model.entities.ObjetivoAprendizaje;
import com.example.micro_academico.ObjetivoDeAprendizaje.model.request.ActualizarObjetivoRequest;
import com.example.micro_academico.ObjetivoDeAprendizaje.model.request.RegistrarObjetivoRequest;
import com.example.micro_academico.ObjetivoDeAprendizaje.repository.ObjetivoAprendizajeRepository;
import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ObjetivoAprendizajeService {

    @Autowired
    private ObjetivoAprendizajeRepository repository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<ObjetivoAprendizaje> obtenerTodos() {
        return repository.findAll();
    }

    public ObjetivoAprendizaje obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objetivo no encontrado"));
    }

    public ObjetivoAprendizaje registrar(RegistrarObjetivoRequest request) {
        Asignatura asignatura = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada"));

        ObjetivoAprendizaje objetivo = new ObjetivoAprendizaje();
        objetivo.setCodigo(request.getCodigo());
        objetivo.setDescripcion(request.getDescripcion());
        objetivo.setNivel(request.getNivel());
        objetivo.setAsignatura(asignatura);
        return repository.save(objetivo);
    }

    public ObjetivoAprendizaje actualizar(Integer id, ActualizarObjetivoRequest request) {
        ObjetivoAprendizaje objetivo = obtenerPorId(id);
        Asignatura asignatura = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada"));
        
        objetivo.setCodigo(request.getCodigo());
        objetivo.setDescripcion(request.getDescripcion());
        objetivo.setNivel(request.getNivel());
        objetivo.setAsignatura(asignatura);
        return repository.save(objetivo);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Objetivo no encontrado");
        }
        repository.deleteById(id);
    }
}