package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Integer> {
    List<Pagos> findByReservaIdReserva(Integer idReserva);
}
