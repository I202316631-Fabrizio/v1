package com.cibertec.gestionHotel.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_reserva_servicios_adicionales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaServiciosAdicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva_servicio")
    private Integer idReservaServicio;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reservas reserva;

    @ManyToOne
    @JoinColumn(name = "id_servicio_adicional", nullable = false)
    private ServiciosAdicionales servicioAdicional;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;
}
