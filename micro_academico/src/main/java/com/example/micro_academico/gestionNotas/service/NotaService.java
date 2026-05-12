package com.example.micro_academico.gestionNotas.service;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import com.example.micro_academico.gestionNotas.repository.NotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class NotaService {
    
    private final NotaRepository notaRepo;

    public NotaService(NotaRepository notaRepo) {
        this.notaRepo = notaRepo;
    }

    public Nota registrarNota(Nota nota) {
        if (nota.getCalificacionObtenida() < 1.0 || nota.getCalificacionObtenida() > 7.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La nota debe estar entre 1.0 y 7.0");
        }
        return notaRepo.save(nota);
    }

    public List<Nota> listarPorEstudiante(Long idEstudiante) {
        return notaRepo.findByIdEstudiante(idEstudiante);
    }

    public void eliminarNota(Long id_nota) {
        if (!notaRepo.existsById(id_nota)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
        }
        notaRepo.deleteById(id_nota);
    }

    public Nota obtenerNotaPorId(Long id_nota) {
        return notaRepo.findById(id_nota)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
    }

    public List<Nota> obtenerTodasLasNotas() {
        return notaRepo.findAll();
    }
}