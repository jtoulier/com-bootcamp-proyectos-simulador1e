package com.bootcamp.proyectos.simulador1e.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultadoSimulacionRequest {

    @NotBlank(message = "DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe ser ocho caracteres")
    private String dni;


    @NotBlank(message = "La tarjeta es obligatoria")
    private String tarjeta ;


    @NotBlank(message = "Moneda es obligatorio")
    @Size(min = 2, max = 3, message = "La moneda debe ser USD o S/")
    private String moneda;

    @NotNull(message = "El monto es obligatorio")
    private Double monto ;

    @NotNull(message = "La cantidad de cuotas es obligatorio")
    private Integer cuota ;

    @NotBlank(message = "La TEA es obligatorio")
    private String tea;

    @NotNull(message = "El dia de pago es obligatorio")
    private Integer diaPago ;
}
