package com.example.micro_academico.gestionNotas.controller;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import com.example.micro_academico.gestionNotas.model.request.ActualizarNotaRequest;
import com.example.micro_academico.gestionNotas.model.request.RegistrarNotaRequest;
import com.example.micro_academico.gestionNotas.service.NotaService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/notas")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> obtenerTodasLasNotas(){
        return notaService.obtenerTodasLasNotas();
    }

    @GetMapping("/estudiante/{id_estudiante}")
    public List<Nota> obtenerNotasPorEstudiante(@PathVariable Integer id_estudiante){
        return notaService.listarPorEstudiante(id_estudiante);
    }

    @PostMapping
    public Nota registrarNota(@RequestBody RegistrarNotaRequest request){
        Nota nuevaNota = new Nota();
        nuevaNota.setIdEstudiante(request.getIdEstudiante());
        nuevaNota.setIdAsignatura(request.getIdAsignatura());
        nuevaNota.setCalificacionObtenida(request.getCalificacionObtenida());
        nuevaNota.setObservacionDocente(request.getObservacionDocente());
        return notaService.registrarNota(nuevaNota);
    }

    @PutMapping("/{id_nota}")
    public Nota actualizarNota(@PathVariable Integer id_nota, @RequestBody ActualizarNotaRequest request){
        Nota notaExistente = notaService.obtenerNotaPorId(id_nota);
        notaExistente.setCalificacionObtenida(request.getCalificacionObtenida());
        return notaService.registrarNota(notaExistente); 
    }

    @DeleteMapping("/{id_nota}")
    public String eliminarNota(@PathVariable Integer id_nota){
        notaService.eliminarNota(id_nota);
        return "Nota eliminada correctamente";
    }
}