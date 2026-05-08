package com.example.micro_academico.gestionAsignatura.service;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.model.request.ActualizarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> obtenerTodasLasAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura obtenerAsignaturaPorId(Integer id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        if (asignatura == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada");
        }
        return asignatura;
    }

    public Asignatura registrarAsignatura(Asignatura asignatura) {
        Asignatura nuevaAsignatura = new Asignatura();
        nuevaAsignatura.setNombreAsignatura(asignatura.getNombreAsignatura());
        nuevaAsignatura.setHorasSemanales(asignatura.getHorasSemanales());
        nuevaAsignatura.setNivelRequerido(asignatura.getNivelRequerido());
        return asignaturaRepository.save(nuevaAsignatura);
    }

    public Asignatura actualizarAsignatura(Asignatura asignatura, ActualizarAsignaturaRequest request) {
        asignatura.setNombreAsignatura(request.getNombreAsignatura());
        asignatura.setHorasSemanales(request.getHorasSemanales());
        asignatura.setNivelRequerido(request.getNivelRequerido());
        return asignaturaRepository.save(asignatura);
    }

    public void eliminarAsignatura(Integer id) {
        if (!asignaturaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada");
        }
        asignaturaRepository.deleteById(id);
    }
}