package com.cibertec.gestionHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cibertec.gestionHotel.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
