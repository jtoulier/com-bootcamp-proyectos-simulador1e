package com.bootcamp.proyectos.simulador1e.domain.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultadoSimulacionRequest {

    @Size(min = 8, max = 8, message = "El DNI debe ser ocho caracteres")
    private String dni;

    private String tarjeta ;

    @Size(min = 2, max = 3, message = "La moneda debe ser S/ o USD")
    private String moneda;

    private Double monto ;
    private Integer cuota ;
    private String tea;
    private Integer diaPago ;
}
