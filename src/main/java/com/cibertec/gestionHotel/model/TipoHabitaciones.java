package com.cibertec.gestionHotel.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tipo_habitaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "nombre_tipo", nullable = false, length = 100)
    private String nombreTipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "capacidad_adultos", nullable = false)
    private Integer capacidadAdultos;

    @Column(name = "capacidad_ninos", nullable = false)
    private Integer capacidadNinos;

    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @Column(name = "horario_comida_incluida", length = 100)
    private String horarioComidaIncluida;
}