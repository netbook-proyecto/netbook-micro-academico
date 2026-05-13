package com.example.micro_academico.gestionCursos.controller;

import com.example.micro_academico.gestionCursos.model.entities.Sala;
import com.example.micro_academico.gestionCursos.model.request.ActualizarSalaRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarSalaRequest;
import com.example.micro_academico.gestionCursos.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public List<Sala> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Sala obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Sala registrar(@Valid @RequestBody RegistrarSalaRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public Sala actualizar(@PathVariable Integer id, @Valid @RequestBody ActualizarSalaRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}