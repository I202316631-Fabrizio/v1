package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.TipoHabitacionBeneficios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TipoHabitacionBeneficiosRepository extends JpaRepository<TipoHabitacionBeneficios, Integer> {
   
	List<TipoHabitacionBeneficios> findByTipoHabitacionIdTipo(Integer idTipo);
}