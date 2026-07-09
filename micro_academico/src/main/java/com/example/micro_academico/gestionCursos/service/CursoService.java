package com.example.micro_academico.gestionCursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.micro_academico.gestionCursos.model.entities.Curso;
import com.example.micro_academico.gestionCursos.repository.CursoRepository;
import com.example.micro_academico.gestionCursos.model.request.ActualizarCursoRequest;
import com.example.micro_academico.gestionCursos.model.request.RegistrarCursoRequest;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoPorId(Integer id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));
    }

    public Curso registrarCurso(RegistrarCursoRequest request) {
        Curso curso = new Curso();
        curso.setLetraCurso(request.getLetraCurso());
        curso.setAnnoAcademico(request.getAnnoAcademico());
        curso.setJornada(request.getJornada());
        curso.setCuposMaximos(request.getCuposMaximos());
        
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Integer id, ActualizarCursoRequest request) {
        Curso curso = obtenerCursoPorId(id); 
        curso.setLetraCurso(request.getLetraCurso());
        curso.setAnnoAcademico(request.getAnnoAcademico());
        curso.setJornada(request.getJornada());
        curso.setCuposMaximos(request.getCuposMaximos());
        
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Integer id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");
        }
        cursoRepository.deleteById(id);
    }
}