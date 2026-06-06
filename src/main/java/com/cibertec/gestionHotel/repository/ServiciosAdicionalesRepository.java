package com.cibertec.gestionHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cibertec.gestionHotel.model.ServiciosAdicionales;

@Repository
public interface ServiciosAdicionalesRepository extends JpaRepository<ServiciosAdicionales, Integer>{

}
