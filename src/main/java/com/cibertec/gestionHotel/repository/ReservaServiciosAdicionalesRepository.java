package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.ReservaServiciosAdicionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaServiciosAdicionalesRepository extends JpaRepository<ReservaServiciosAdicionales, Integer> {
    List<ReservaServiciosAdicionales> findByReservaIdReserva(Integer idReserva);
}