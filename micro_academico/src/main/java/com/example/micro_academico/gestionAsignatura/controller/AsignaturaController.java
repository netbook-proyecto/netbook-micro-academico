package com.example.micro_academico.gestionAsignatura.controller;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.model.request.ActualizarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.model.request.RegistrarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.service.AsignaturaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping 
    public List<Asignatura> obtenerTodasLasAsignaturas(){
        return asignaturaService.obtenerTodasLasAsignaturas();
    }

    @GetMapping("/{id}")
    public Asignatura obtenerAsignaturaPorId(@PathVariable Integer id){
        return asignaturaService.obtenerAsignaturaPorId(id);
    }

    @PostMapping
    public Asignatura registrarAsignatura(@Valid @RequestBody RegistrarAsignaturaRequest request){
        return asignaturaService.registrarAsignatura(request);
    }

    @PutMapping("/{id}")
    public Asignatura actualizarAsignatura(@PathVariable Integer id, @RequestBody ActualizarAsignaturaRequest request){
        return asignaturaService.actualizarAsignatura(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarAsignatura(@PathVariable Integer id){
        asignaturaService.eliminarAsignatura(id);
    }
}