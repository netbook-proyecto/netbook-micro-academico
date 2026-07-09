package com.example.micro_academico.gestionCursos.service;

import com.example.micro_academico.gestionCursos.model.entities.Sala;
import com.example.micro_academico.gestionCursos.model.request.ActualizarSalaRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarSalaRequest;
import com.example.micro_academico.gestionCursos.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;

    public List<Sala> obtenerTodas() {
        return repository.findAll();
    }

    public Sala obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala no encontrada"));
    }

    public Sala registrar(RegistrarSalaRequest request) {
        Sala sala = new Sala();
        sala.setNombreSala(request.getNombreSala());
        sala.setCapacidad(request.getCapacidad());
        return repository.save(sala);
    }

    public Sala actualizar(Integer id, ActualizarSalaRequest request) {
        Sala sala = obtenerPorId(id);
        sala.setNombreSala(request.getNombreSala());
        sala.setCapacidad(request.getCapacidad());
        return repository.save(sala);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala no encontrada");
        }
        repository.deleteById(id);
    }
}