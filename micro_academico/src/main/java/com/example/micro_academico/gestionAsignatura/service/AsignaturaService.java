package com.example.micro_academico.gestionAsignatura.service;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.model.request.ActualizarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.model.request.RegistrarAsignaturaRequest;
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
        return asignaturaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada"));
    }

    public Asignatura registrarAsignatura(RegistrarAsignaturaRequest request) {
        Asignatura nuevaAsignatura = new Asignatura();
        nuevaAsignatura.setNombreAsignatura(request.getNombreAsignatura());
        nuevaAsignatura.setHorasSemanales(request.getHorasSemanales());
        nuevaAsignatura.setNivelRequerido(request.getNivelRequerido());
        return asignaturaRepository.save(nuevaAsignatura);
    }

    public Asignatura actualizarAsignatura(Integer id, ActualizarAsignaturaRequest request) {
        Asignatura asignatura = obtenerAsignaturaPorId(id);
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