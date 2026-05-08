package com.example.micro_academico.bitacoraAsignatura.service;

import com.example.micro_academico.bitacoraAsignatura.model.entities.BitacoraAsignatura;
import com.example.micro_academico.bitacoraAsignatura.model.request.ActualizarBitacoraRequest;
import com.example.micro_academico.bitacoraAsignatura.model.request.RegistrarBitacoraRequest;
import com.example.micro_academico.bitacoraAsignatura.repository.BitacoraAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BitacoraAsignaturaService {
    @Autowired
    private BitacoraAsignaturaRepository bitacoraAsignaturaRepository;

    public List<BitacoraAsignatura> obtenerTodasLasBitacoras() {
        return bitacoraAsignaturaRepository.findAll();
    }

    public Optional<BitacoraAsignatura> obtenerBitacoraPorId(Long id) {
        return bitacoraAsignaturaRepository.findById(id);
    }

    public BitacoraAsignatura registrarBitacora(RegistrarBitacoraRequest request) {
        BitacoraAsignatura bitacora = new BitacoraAsignatura();
        bitacora.setFechaClase(request.getFechaClase());
        bitacora.setActividadesRealizadas(request.getActividadesRealizadas());
        bitacora.setContenidosTratados(request.getContenidosTratados());
        bitacora.setObservacionesGenerales(request.getObservacionesGenerales());
        return bitacoraAsignaturaRepository.save(bitacora);
    }

    public BitacoraAsignatura actualizarBitacora(Long id, ActualizarBitacoraRequest request) {
        return bitacoraAsignaturaRepository.findById(id).map(bitacora -> {
            bitacora.setFechaClase(request.getFechaClase());
            bitacora.setActividadesRealizadas(request.getActividadesRealizadas());
            bitacora.setContenidosTratados(request.getContenidosTratados());
            bitacora.setObservacionesGenerales(request.getObservacionesGenerales());
            return bitacoraAsignaturaRepository.save(bitacora);
        }).orElse(null);
    }
    public void eliminarBitacora(Long id) {
        bitacoraAsignaturaRepository.deleteById(id);
    }
}
