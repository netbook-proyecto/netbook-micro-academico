package com.example.micro_academico.gestionEvaluacion.service;

import com.example.micro_academico.gestionEvaluacion.model.entities.Evaluacion;
import com.example.micro_academico.gestionEvaluacion.model.request.ActualizarEvaluacionRequest;
import com.example.micro_academico.gestionEvaluacion.model.request.RegistrarEvaluacionRequest;
import com.example.micro_academico.gestionEvaluacion.repository.EvaluacionRepository;
import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Evaluacion> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    public Evaluacion obtenerEvaluacionPorId(Integer id) {
        return evaluacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluación no encontrada"));
    }

    public Evaluacion registrarEvaluacion(RegistrarEvaluacionRequest request) {
        Asignatura asignatura = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada"));

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setValorNota(request.getValorNota());
        evaluacion.setPonderacionPorcentaje(request.getPonderacionPorcentaje());
        evaluacion.setFechaEvaluacion(request.getFechaEvaluacion());
        evaluacion.setTipoEvaluacion(request.getTipoEvaluacion());
        evaluacion.setAsignatura(asignatura);

        return evaluacionRepository.save(evaluacion);
    }

    public Evaluacion actualizarEvaluacion(Integer id, ActualizarEvaluacionRequest request) {
        Evaluacion evaluacion = obtenerEvaluacionPorId(id);

        Asignatura asignatura = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada"));

        evaluacion.setValorNota(request.getValorNota());
        evaluacion.setPonderacionPorcentaje(request.getPonderacionPorcentaje());
        evaluacion.setFechaEvaluacion(request.getFechaEvaluacion());
        evaluacion.setTipoEvaluacion(request.getTipoEvaluacion());
        evaluacion.setAsignatura(asignatura);

        return evaluacionRepository.save(evaluacion);
    }

    public void eliminarEvaluacion(Integer id) {
        if (!evaluacionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluación no encontrada");
        }
        evaluacionRepository.deleteById(id);
    }
}