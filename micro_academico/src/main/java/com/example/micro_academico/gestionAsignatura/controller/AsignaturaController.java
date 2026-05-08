package com.example.micro_academico.gestionAsignatura.controller;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.model.request.ActualizarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.model.request.RegistrarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.service.AsignaturaService;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Asignatura registrarAsignatura(@RequestBody RegistrarAsignaturaRequest request){
        Asignatura asignatura = new Asignatura();
        return asignaturaService.registrarAsignatura(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura actualizarAsignatura(@PathVariable Integer id, @RequestBody ActualizarAsignaturaRequest request){
        Asignatura asignatura = asignaturaService.obtenerAsignaturaPorId(id);
        return asignaturaService.actualizarAsignatura(asignatura, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarAsignatura(@PathVariable Integer id){
        asignaturaService.eliminarAsignatura(id);
    }
}