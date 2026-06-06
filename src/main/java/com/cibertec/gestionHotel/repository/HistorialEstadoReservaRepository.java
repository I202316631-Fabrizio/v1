package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.HistorialEstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HistorialEstadoReservaRepository extends JpaRepository<HistorialEstadoReserva, Integer> {
    List<HistorialEstadoReserva> findByReservaIdReservaOrderByFechaCambioAsc(Integer idReserva);
}
