package com.cibertec.gestionHotel.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class ReservaServiciosAdicionalesRequest {
    @JsonAlias("id_reserva")
    private Integer idReserva;

    @JsonAlias("id_servicio_adicional")
    private Integer idServicioAdicional;

    private Integer cantidad;

    @JsonAlias("precio_unitario")
    private BigDecimal precioUnitario;
}
