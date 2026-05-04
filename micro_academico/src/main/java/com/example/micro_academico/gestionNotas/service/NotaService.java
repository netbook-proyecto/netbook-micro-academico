package com.example.micro_academico.gestionNotas.service;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import com.example.micro_academico.gestionNotas.repository.NotaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotaService {
    
    private final NotaRepository notaRepo;

    public NotaService(NotaRepository notaRepo) {
        this.notaRepo = notaRepo;
    }

    public Nota registrarNota(Nota nota) {
        // Validacion logica del rango de la nota
        if (nota.getCalificacionObtenida() < 1.0 || nota.getCalificacionObtenida() > 7.0) {
            throw new RuntimeException("La nota debe estar entre 1.0 y 7.0");
        }
        return notaRepo.save(nota);
    }

    public List<Nota> listarPorEstudiante(Long idEstudiante) {
        return notaRepo.findByIdEstudiante(idEstudiante);
    }

    public void eliminarNota(Long id_nota) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarNota'");
    }

    public Nota obtenerNotaPorId(Long id_nota) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNotaPorId'");
    }

    public List<Nota> obtenerTodasLasNotas() {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodasLasNotas'");
    }
}