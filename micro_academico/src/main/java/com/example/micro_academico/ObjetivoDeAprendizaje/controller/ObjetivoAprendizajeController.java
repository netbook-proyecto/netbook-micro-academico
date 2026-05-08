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
    public List<ObjetivoAprendizaje> obtenerTodosLosObjetivo() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ObjetivoAprendizaje obtenerObjetivoPorId(@PathVariable Long id) {
        return service.obtenerPorId(id).orElse(null);
    }

    @PostMapping
    public ObjetivoAprendizaje registrarObjetivo(@Valid @RequestBody RegistrarObjetivoRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public ObjetivoAprendizaje actualizarObjetivo(@PathVariable Long id, @RequestBody ActualizarObjetivoRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarObjetivo(@PathVariable Long id) {
        service.eliminar(id);
    }
}