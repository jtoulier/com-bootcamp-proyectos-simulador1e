package com.bootcamp.proyectos.simulador1e.domain.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultadoSimulacionResponse {
    private Double cuota;
    private String moneda ;
    private LocalDate primeraCuota;
    private String estado ;
}
