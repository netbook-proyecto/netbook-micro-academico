package com.example.micro_academico.gestionCursos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.micro_academico.gestionCursos.model.entities.Curso;
import com.example.micro_academico.gestionCursos.model.request.ActualizarCursoRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarCursoRequest;
import com.example.micro_academico.gestionCursos.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping 
    public List<Curso> obtenerTodasLosCursos(){
        return cursoService.obtenerTodosLosCursos();
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable Long id){
        return cursoService.obtenerCursoPorId(id).orElse(null);
    }

    @PostMapping
    public Curso registrarCurso(@Valid @RequestBody RegistrarCursoRequest request){
        return cursoService.registrarCurso(request);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody ActualizarCursoRequest request){
        return cursoService.actualizarCurso(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
    }
}