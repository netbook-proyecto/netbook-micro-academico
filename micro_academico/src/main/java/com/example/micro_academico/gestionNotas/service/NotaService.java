package com.example.micro_academico.gestionNotas.service;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import com.example.micro_academico.gestionNotas.repository.NotaRepository;
import com.example.micro_academico.gestionEvaluacion.model.entities.Evaluacion;
import com.example.micro_academico.gestionEvaluacion.repository.EvaluacionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class NotaService {
    
    private final NotaRepository notaRepo;
    private final EvaluacionRepository evaluacionRepo;
    public NotaService(NotaRepository notaRepo, EvaluacionRepository evaluacionRepo) {
        this.notaRepo = notaRepo;
        this.evaluacionRepo = evaluacionRepo;
    }

    public Nota registrarNota(Nota nota) {
        if (nota.getCalificacionObtenida() < 1.0 || nota.getCalificacionObtenida() > 7.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La nota debe estar entre 1.0 y 7.0");
        }

        if (nota.getEvaluacion() == null || nota.getEvaluacion().getIdEvaluacion() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La nota debe tener el ID de una evaluación válida");
        }

        Evaluacion evaluacionEncontrada = evaluacionRepo.findById(nota.getEvaluacion().getIdEvaluacion())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La evaluación indicada no existe"));
        nota.setEvaluacion(evaluacionEncontrada);
        return notaRepo.save(nota);
    }

    public List<Nota> listarPorEstudiante(Integer idEstudiante) {
        return notaRepo.findByIdEstudiante(idEstudiante);
    }

    public void eliminarNota(Integer id_nota) {
        if (!notaRepo.existsById(id_nota)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
        }
        notaRepo.deleteById(id_nota);
    }

    public Nota obtenerNotaPorId(Integer id_nota) {
        return notaRepo.findById(id_nota)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
    }

    public List<Nota> obtenerTodasLasNotas() {
        return notaRepo.findAll();
    }
}