package com.example.micro_academico.gestionNotas.controller;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import com.example.micro_academico.gestionNotas.model.request.RegistrarNotaRequest;
import com.example.micro_academico.gestionNotas.service.NotaService;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @GetMapping("")
    public List<Nota> obtenerTodasLasNotas(){
        return notaService.obtenerTodasLasNotas();
    }

    @GetMapping("/estudiante/{id_estudiante}")
    public List<Nota> obtenerNotasPorEstudiante(@PathVariable Long id_estudiante){
        return notaService.listarPorEstudiante(id_estudiante);
    }

    @PostMapping("")
    public Nota registrarNota(@RequestBody RegistrarNotaRequest request){
        Nota nuevaNota = new Nota();
        nuevaNota.setIdEstudiante(request.getIdEstudiante());
        nuevaNota.setIdAsignatura(request.getIdAsignatura());
        nuevaNota.setCalificacionObtenida(request.getCalificacionObtenida());
        return notaService.registrarNota(nuevaNota);
    }

@PutMapping("/{id_nota}")
    public Nota actualizarNota(@PathVariable Long id_nota, @RequestBody ActualizarNotaRequest request){
        Nota notaExistente = notaService.obtenerNotaPorId(id_nota);
        if (notaExistente == null) {
            throw new RuntimeException("Nota no encontrada");
        }
        notaExistente.setCalificacionObtenida(request.getCalificacionObtenida());
        return notaService.registrarNota(notaExistente); 
    }
    @DeleteMapping("/{id_nota}")
    public String eliminarNota(@PathVariable Long id_nota){
        notaService.eliminarNota(id_nota);
        return "Nota eliminada exitosamente";
    }

}
