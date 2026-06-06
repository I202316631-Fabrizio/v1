package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.TipoHabitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionesRepository extends JpaRepository<TipoHabitaciones, Integer> {
}