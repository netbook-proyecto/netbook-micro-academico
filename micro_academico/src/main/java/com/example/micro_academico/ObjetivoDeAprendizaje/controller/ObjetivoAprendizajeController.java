package com.example.micro_academico.ObjetivoDeAprendizaje.controller;

import com.example.micro_academico.ObjetivoDeAprendizaje.model.entities.ObjetivoAprendizaje;
import com.example.micro_academico.ObjetivoDeAprendizaje.model.request.ActualizarObjetivoRequest;
import com.example.micro_academico.ObjetivoDeAprendizaje.model.request.RegistrarObjetivoRequest;
import com.example.micro_academico.ObjetivoDeAprendizaje.service.ObjetivoAprendizajeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoAprendizajeController {

    @Autowired
    private ObjetivoAprendizajeService service;

    @GetMapping
    public List<ObjetivoAprendizaje> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ObjetivoAprendizaje obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public ObjetivoAprendizaje registrar(@Valid @RequestBody RegistrarObjetivoRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public ObjetivoAprendizaje actualizar(@PathVariable Integer id, @Valid @RequestBody ActualizarObjetivoRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}