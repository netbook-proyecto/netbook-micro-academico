package com.example.micro_academico.gestionCursos.controller;

import com.example.micro_academico.gestionCursos.model.entities.Nivel;
import com.example.micro_academico.gestionCursos.model.request.ActualizarNivelRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarNivelRequest;
import com.example.micro_academico.gestionCursos.service.NivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveles")
public class NivelController {

    @Autowired
    private NivelService service;

    @GetMapping
    public List<Nivel> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Nivel obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Nivel registrar(@Valid @RequestBody RegistrarNivelRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public Nivel actualizar(@PathVariable Integer id, @Valid @RequestBody ActualizarNivelRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}