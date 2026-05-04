package com.example.micro_academico.gestionAsignatura.controller;

import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.model.request.ActualizarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.model.request.RegistrarAsignaturaRequest;
import com.example.micro_academico.gestionAsignatura.service.AsignaturaService;
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
@RequestMapping("/Asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("")
    public List<Asignatura> obtenerTodasLasAsignaturas(){
        return asignaturaService.obtenerTodasLasAsignaturas();
    }

    @PostMapping("")
    public Asignatura registrarAsignatura(@RequestBody RegistrarAsignaturaRequest request){
        Asignatura nuevaAsignatura = new Asignatura();
        nuevaAsignatura.setNombreAsigantura(request.getNombreAsignatura());
        nuevaAsignatura.setHoraSemanales(request.getHorasSemanales());
        nuevaAsignatura.setNivelRequerido(request.getNiverRequerido());
        return asignaturaService.registrarAsignatura(nuevaAsignatura);
    }
    
    @PutMapping("/{id_asignatura}")
    public Asignatura actualizarAsignatura(@PathVariable Long id_asignatura, @RequestBody ActualizarAsignaturaRequest request){
        Asignatura asignaturaExistente = asignaturaService.obtenerAsignaturaPorId(id_asignatura);
        if (asignaturaExistente == null) {
            throw new RuntimeException("Asignatura no encontrada");
        }
        
        asignaturaExistente.setNombreAsigantura(request.getNombreAsignatura());
        asignaturaExistente.setHoraSemanales(request.getHorasSemanales());
        asignaturaExistente.setNivelRequerido(request.getNivelRequerido());
        
        return asignaturaService.registrarAsignatura(asignaturaExistente); 
    }

    @DeleteMapping("/{id_asignatura}")
    public String eliminarAsignatura(@PathVariable Long id_asignatura){
        asignaturaService.eliminarAsignatura(id_asignatura);
        return "Asignatura eliminada exitosamente";
    }
}
