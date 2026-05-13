package com.example.micro_academico.gestionEvaluacion.controller;

import com.example.micro_academico.gestionEvaluacion.model.entities.Evaluacion;
import com.example.micro_academico.gestionEvaluacion.model.request.ActualizarEvaluacionRequest;
import com.example.micro_academico.gestionEvaluacion.model.request.RegistrarEvaluacionRequest;
import com.example.micro_academico.gestionEvaluacion.service.EvaluacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService service;

    @GetMapping
    public List<Evaluacion> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Evaluacion obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Evaluacion registrar(@Valid @RequestBody RegistrarEvaluacionRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizar(@PathVariable Long id, @Valid @RequestBody ActualizarEvaluacionRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}