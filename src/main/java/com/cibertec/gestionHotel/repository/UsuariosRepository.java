package com.cibertec.gestionHotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.gestionHotel.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{

	Optional<Usuarios> findByEmail(String email);
    Optional<Usuarios> findByNroDocumento(String nroDocumento);
}
