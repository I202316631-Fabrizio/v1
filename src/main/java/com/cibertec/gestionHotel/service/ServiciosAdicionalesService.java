package com.cibertec.gestionHotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.gestionHotel.exception.ResourceNotFoundException;
import com.cibertec.gestionHotel.model.ServiciosAdicionales;
import com.cibertec.gestionHotel.repository.ServiciosAdicionalesRepository;

@Service
public class ServiciosAdicionalesService {

    private final ServiciosAdicionalesRepository serviciosAdicionalesRepository;

    public ServiciosAdicionalesService(ServiciosAdicionalesRepository serviciosAdicionalesRepository) {
        this.serviciosAdicionalesRepository = serviciosAdicionalesRepository;
    }

    @Transactional(readOnly = true)
    public List<ServiciosAdicionales> listarTodos() {
        return serviciosAdicionalesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ServiciosAdicionales obtenerPorId(Integer id) {
        return serviciosAdicionalesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio adicional no encontrado con id: " + id));
    }

    @Transactional
    public ServiciosAdicionales crear(ServiciosAdicionales servicio) {
        servicio.setIdServicioAdicional(null);
        return serviciosAdicionalesRepository.save(servicio);
    }

    @Transactional
    public ServiciosAdicionales actualizar(Integer id, ServiciosAdicionales servicio) {
        ServiciosAdicionales servicioExistente = obtenerPorId(id);

        servicioExistente.setNombre(servicio.getNombre());
        servicioExistente.setDescripcion(servicio.getDescripcion());
        servicioExistente.setPrecio(servicio.getPrecio());
        servicioExistente.setHorarioServicio(servicio.getHorarioServicio());

        return serviciosAdicionalesRepository.save(servicioExistente);
    }

    @Transactional
    public void eliminar(Integer id) {
        ServiciosAdicionales servicio = obtenerPorId(id);
        serviciosAdicionalesRepository.delete(servicio);
    }
}
