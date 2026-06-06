package com.cibertec.gestionHotel.repository;

import com.cibertec.gestionHotel.model.Estacionamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Integer> {
    List<Estacionamiento> findByEstado(String estado);
}