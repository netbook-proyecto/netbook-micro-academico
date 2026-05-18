package com.example.micro_academico.gestionCursos.controller;

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

    // ¡AQUÍ ESTÁ LA MAGIA! Le agregamos ("id")
    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable("id") Integer id){
        return cursoService.obtenerCursoPorId(id);
    }

    @PostMapping
    public Curso registrarCurso(@RequestBody RegistrarCursoRequest request){
        return cursoService.registrarCurso(request);
    }

    // ¡AQUÍ TAMBIÉN!
    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable("id") Integer id, @RequestBody ActualizarCursoRequest request){
        return cursoService.actualizarCurso(id, request);
    }

    // ¡Y AQUÍ!
    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable("id") Integer id){
        cursoService.eliminarCurso(id);
    }
}