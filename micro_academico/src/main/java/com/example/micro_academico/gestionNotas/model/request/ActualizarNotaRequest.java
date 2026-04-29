package com.example.micro_academico.gestionNotas.model.request;

import com.example.micro_academico.gestionNotas.model.entities.Nota;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class ActualizarNotaRequest {
    
    @NotNull
    private Double calificacionObtenida;
    
}

