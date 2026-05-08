package com.example.micro_academico.bitacoraAsignatura.model.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RegistrarBitacoraRequest {
    private LocalDate fechaClase;
    private String actividadesRealizadas;
    private String contenidosTratados;
    private String observacionesGenerales;
}
