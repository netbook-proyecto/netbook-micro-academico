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
        return service.obtenerTodasLasEvaluaciones();
    }

    @GetMapping("/{id}")
    public Evaluacion obtenerPorId(@PathVariable Integer id) {
        return service.obtenerEvaluacionPorId(id);
    }

    @PostMapping
    public Evaluacion registrar(@Valid @RequestBody RegistrarEvaluacionRequest request) {
        return service.registrarEvaluacion(request);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizar(@PathVariable Integer id, @Valid @RequestBody ActualizarEvaluacionRequest request) {
        return service.actualizarEvaluacion(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarEvaluacion(id);
    }
}