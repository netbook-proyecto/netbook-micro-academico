package com.example.micro_academico.bitacoraAsignatura.service;

import com.example.micro_academico.bitacoraAsignatura.model.entities.BitacoraAsignatura;
import com.example.micro_academico.bitacoraAsignatura.model.request.ActualizarBitacoraRequest;
import com.example.micro_academico.bitacoraAsignatura.model.request.RegistrarBitacoraRequest;
import com.example.micro_academico.bitacoraAsignatura.repository.BitacoraAsignaturaRepository;
import com.example.micro_academico.gestionAsignatura.model.entities.Asignatura;
import com.example.micro_academico.gestionAsignatura.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BitacoraAsignaturaService {
    
    @Autowired
    private BitacoraAsignaturaRepository bitacoraAsignaturaRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<BitacoraAsignatura> obtenerTodasLasBitacoras() {
        return bitacoraAsignaturaRepository.findAll();
    }

    public Optional<BitacoraAsignatura> obtenerBitacoraPorId(Integer id) {
        return bitacoraAsignaturaRepository.findById(id);
    }

    public BitacoraAsignatura registrarBitacora(RegistrarBitacoraRequest request) {
        // AQUÍ ESTÁ LA CORRECCIÓN: Le pasamos el ID directo, sin el valueOf
        Asignatura asignaturaEncontrada = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Error: Asignatura no encontrada con el ID: " + request.getIdAsignatura()));
                
        BitacoraAsignatura bitacora = new BitacoraAsignatura();
        bitacora.setFechaClase(request.getFechaClase());
        bitacora.setActividadesRealizadas(request.getActividadesRealizadas());
        bitacora.setContenidosTratados(request.getContenidosTratados());
        bitacora.setObservacionesGenerales(request.getObservacionesGenerales());
        bitacora.setAsignatura(asignaturaEncontrada);
        return bitacoraAsignaturaRepository.save(bitacora);
    }

    public BitacoraAsignatura actualizarBitacora(Integer id, ActualizarBitacoraRequest request) {
        return bitacoraAsignaturaRepository.findById(id).map(bitacora -> {
            bitacora.setFechaClase(request.getFechaClase());
            bitacora.setActividadesRealizadas(request.getActividadesRealizadas());
            bitacora.setContenidosTratados(request.getContenidosTratados());
            bitacora.setObservacionesGenerales(request.getObservacionesGenerales());
            return bitacoraAsignaturaRepository.save(bitacora);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Bitácora no encontrada con el ID: " + id));
    }

    public void eliminarBitacora(Integer id) {
        BitacoraAsignatura bitacoraEncontrada = bitacoraAsignaturaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Bitácora no encontrada para eliminar"));
                bitacoraAsignaturaRepository.delete(bitacoraEncontrada);
    }
}