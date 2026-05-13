package com.example.micro_academico.gestionCursos.service;

import com.example.micro_academico.gestionCursos.model.entities.Nivel;
import com.example.micro_academico.gestionCursos.model.request.ActualizarNivelRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarNivelRequest;
import com.example.micro_academico.gestionCursos.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NivelService {

    @Autowired
    private NivelRepository repository;

    public List<Nivel> obtenerTodos() {
        return repository.findAll();
    }

    public Nivel obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nivel no encontrado"));
    }

    public Nivel registrar(RegistrarNivelRequest request) {
        Nivel nivel = new Nivel();
        nivel.setNombreNivel(request.getNombreNivel());
        return repository.save(nivel);
    }

    public Nivel actualizar(Integer id, ActualizarNivelRequest request) {
        Nivel nivel = obtenerPorId(id);
        nivel.setNombreNivel(request.getNombreNivel());
        return repository.save(nivel);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nivel no encontrado");
        }
        repository.deleteById(id);
    }
}