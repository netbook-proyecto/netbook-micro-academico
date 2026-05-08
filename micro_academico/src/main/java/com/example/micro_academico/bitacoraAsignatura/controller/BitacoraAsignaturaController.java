package com.example.micro_academico.bitacoraAsignatura.controller;

import com.example.micro_academico.bitacoraAsignatura.model.entities.BitacoraAsignatura;
import com.example.micro_academico.bitacoraAsignatura.model.request.ActualizarBitacoraRequest;
import com.example.micro_academico.bitacoraAsignatura.model.request.RegistrarBitacoraRequest;
import com.example.micro_academico.bitacoraAsignatura.service.BitacoraAsignaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitacoras")
public class BitacoraAsignaturaController {
    @Autowired
    private BitacoraAsignaturaService bitacoraAsignaturaService;

    @GetMapping
    public List<BitacoraAsignatura> obtenerTodasLasBitacoras() {
        return bitacoraAsignaturaService.obtenerTodasLasBitacoras();
    }

    @GetMapping("/{id}")
    public BitacoraAsignatura obtenerBitacoraPorId(@PathVariable Long id) {
        return bitacoraAsignaturaService.obtenerBitacoraPorId(id).orElse(null);
    }

    @PostMapping
    public BitacoraAsignatura registrarBitacora(@Valid @RequestBody RegistrarBitacoraRequest request) {
        return bitacoraAsignaturaService.registrarBitacora(request);
    }

    @PutMapping("/{id}")
    public BitacoraAsignatura actualizarBitacora(@PathVariable Long id, @Valid @RequestBody ActualizarBitacoraRequest request) {
        return bitacoraAsignaturaService.actualizarBitacora(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarBitacora(@PathVariable Long id) {
        bitacoraAsignaturaService.eliminarBitacora(id);
    }
}