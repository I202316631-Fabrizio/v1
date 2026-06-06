package com.cibertec.gestionHotel.model;


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
@Table(name = "tbl_tipo_habitacion_beneficios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacionBeneficios {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_beneficio")
    private Integer idTipoBeneficio;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoHabitaciones tipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_beneficio_incluido")
    private BeneficioIncluido beneficioIncluido;
}