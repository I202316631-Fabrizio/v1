package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {
	
    List<Reservas> findByUsuarioIdUsuarios(Integer idUsuarios);
    List<Reservas> findByEstadoReserva(String estadoReserva);
}
