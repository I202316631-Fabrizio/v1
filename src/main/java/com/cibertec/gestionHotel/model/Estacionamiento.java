package com.cibertec.gestionHotel.model;

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
@Table(name = "tbl_estacionamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacionamiento")
    private Integer idEstacionamiento;

    @Column(name = "numero_sitio", nullable = false, unique = true, length = 10)
    private String numeroSitio;

    @Column(length = 30)
    private String estado;
}