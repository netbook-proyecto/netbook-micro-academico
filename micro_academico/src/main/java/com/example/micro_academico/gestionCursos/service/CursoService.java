package com.example.micro_academico.gestionCursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.micro_academico.gestionCursos.model.entities.Curso;
import com.example.micro_academico.gestionCursos.repository.CursoRepository;
import com.example.micro_academico.gestionCursos.model.request.ActualizarCursoRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarCursoRequest;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso registrarCurso(RegistrarCursoRequest request) {
        Curso curso = new Curso();
        curso.setLetraCurso(request.getLetraCurso());
        curso.setAnnoAcademico(request.getAnnoAcademico());
        curso.setJornada(request.getJornada());
        curso.setCuposMaximos(request.getCuposMaximos());
        
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Long id, ActualizarCursoRequest request) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setLetraCurso(request.getLetraCurso());
            curso.setAnnoAcademico(request.getAnnoAcademico());
            curso.setJornada(request.getJornada());
            curso.setCuposMaximos(request.getCuposMaximos());
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso no encontrado con el ID: " + id));
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}