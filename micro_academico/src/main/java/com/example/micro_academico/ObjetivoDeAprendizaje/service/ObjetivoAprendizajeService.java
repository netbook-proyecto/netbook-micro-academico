package com.example.micro_academico.ObjetivoDeAprendizaje.service;

import com.example.micro_academico.ObjetivoDeAprendizaje.model.entities.ObjetivoAprendizaje;
import com.example.micro_academico.ObjetivoDeAprendizaje.model.request.ActualizarObjetivoRequest;
import com.example.micro_academico.ObjetivoDeAprendizaje.model.request.RegistrarObjetivoRequest;
import com.example.micro_academico.ObjetivoDeAprendizaje.repository.ObjetivoAprendizajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoAprendizajeService {

        @Autowired
    private ObjetivoAprendizajeRepository repository;

    public List<ObjetivoAprendizaje> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<ObjetivoAprendizaje> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public ObjetivoAprendizaje registrar(RegistrarObjetivoRequest request) {
        ObjetivoAprendizaje objetivo = new ObjetivoAprendizaje();
        objetivo.setCodigo(request.getCodigo());
        objetivo.setDescripcion(request.getDescripcion());
        objetivo.setAsignatura(request.getAsignatura());
        objetivo.setNivel(request.getNivel());
        return repository.save(objetivo);
    }

    public ObjetivoAprendizaje actualizar(Long id, ActualizarObjetivoRequest request) {
        Optional<ObjetivoAprendizaje> optionalObjetivo = repository.findById(id);
        if (optionalObjetivo.isPresent()) {
            ObjetivoAprendizaje objetivo = optionalObjetivo.get();
            objetivo.setCodigo(request.getCodigo());
            objetivo.setDescripcion(request.getDescripcion());
            objetivo.setAsignatura(request.getAsignatura());
            objetivo.setNivel(request.getNivel());
            return repository.save(objetivo);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
